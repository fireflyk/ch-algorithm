package com.codinghero.interview.openai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ToyLanguage {

    private static final Set<String> PRIMITIVE_TYPES = Set.of("int", "string", "float");

    enum NodeType {
        PRIMITIVE, GENERIC, LIST;
    }

    static class Node {

        Node(String basicType) {
            if (PRIMITIVE_TYPES.contains(basicType)) {
                this.nodeType = NodeType.PRIMITIVE;
            } else {
                this.nodeType = NodeType.GENERIC;
            }
            this.basicType = basicType;
        }

        Node(List<Node> nodes) {
            this.nodeType = NodeType.LIST;
            this.nodes = nodes;
        }

        Enum nodeType;

        String basicType;

        List<Node> nodes;

        private boolean isBasicType() {
            return nodeType == NodeType.PRIMITIVE || nodeType == NodeType.GENERIC;
        }

        private boolean isListType() {
            return nodeType == NodeType.LIST;
        }

        /**
         * Step 1: Convert Node to String
         *
         * @return
         */
        public String toString() {
            if (this.isBasicType()) {
                return basicType;
            } else if (this.isListType()) {
                final StringBuilder sb = new StringBuilder();
                sb.append("[");
                for (int i = 0; i < nodes.size(); i++) {
                    sb.append(nodes.get(i).toString());
                    if (i < nodes.size() - 1) {
                        sb.append(", ");
                    }
                }
                sb.append("]");
                return sb.toString();
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    static class FunctionResult {

        FunctionResult(boolean isValid, Node returnType) {
            this.isValid = isValid;
            this.returnType = returnType;
        }

        Node returnType;

        boolean isValid;
    }

    static class Function {

        private List<Node> originalInputTypes;

        private Node originalReturnType;

        Function(
            List<Node> originalInputTypes,
            Node originalReturnType) {
            this.originalInputTypes = originalInputTypes;
            this.originalReturnType = originalReturnType;
        }

        private boolean process(
            List<Node> originalInputTypes,
            List<Node> actualInputTypes,
            Map<String, String> genericTypeMappings) {
            for(int i = 0; i < originalInputTypes.size(); i++) {
                Node originalInputType = originalInputTypes.get(i);
                Node actualInputType = actualInputTypes.get(i);
                if (originalInputType.nodeType == NodeType.PRIMITIVE) {
                    if (!Objects.equals(originalInputType.basicType, actualInputType.basicType)) {
                        return false;
                    }
                } else if (originalInputType.nodeType == NodeType.GENERIC) {
                    if (!genericTypeMappings.containsKey(originalInputType.basicType)) {
                        genericTypeMappings.put(originalInputType.basicType, actualInputType.basicType);
                    } else {
                        if (!Objects.equals(actualInputType.basicType, genericTypeMappings.get(originalInputType.basicType))) {
                            return false;
                        }
                    }
                } else if (originalInputType.nodeType == NodeType.LIST) {
                    process(originalInputType.nodes, actualInputType.nodes, genericTypeMappings);
                } else {
                    return false;
                }
            }
            return true;
        }

        FunctionResult constructReturnType(
            Node originalReturnType,
            Map<String, String> genericTypeMappings) {
            if (originalReturnType.nodeType == NodeType.PRIMITIVE) {
                return new FunctionResult(true, originalReturnType);
            } else if (originalReturnType.nodeType == NodeType.GENERIC) {
                if (genericTypeMappings.containsKey(originalReturnType.basicType)) {
                    String actualType = genericTypeMappings.get(originalReturnType.basicType);
                    return new FunctionResult(true, new Node(actualType));
                } else {
                    return new FunctionResult(false, null);
                }
            } else if (originalReturnType.nodeType == NodeType.LIST) {
                List<Node> newNodes = new ArrayList<>();
                for (Node subNode : originalReturnType.nodes) {
                    FunctionResult subNodeResult = constructReturnType(subNode, genericTypeMappings);
                    if(subNodeResult.isValid) {
                        newNodes.add(subNodeResult.returnType);
                    } else {
                        return new FunctionResult(false, null);
                    }
                }
                return new FunctionResult(true, new Node(newNodes));
            } else {
                return new FunctionResult(false, null);
            }
        }

        /**
         * Step 2: Get Return Type
         * - Get generic type by comparing original input and actual input
         *  - if generic type is found, get the actual type and verify match
         *  - if primitive type is found, verify match
         * - Substitute generic type in output with actual type
         *
         * @param actualInputTypes
         * @return
         */
        public FunctionResult getReturnType(
            List<Node> actualInputTypes) {
            Map<String, String> genericTypeMappings = new HashMap<>();
            if (this.process(this.originalInputTypes, actualInputTypes, genericTypeMappings)) {
                return this.constructReturnType(this.originalReturnType, genericTypeMappings);
            } else {
                return new FunctionResult(false, null);
            }
        }
    }

    public static void main(String[] args) {
        // Step 1
        System.out.println(new Node("int"));
        System.out.println(new Node(List.of(new Node("int"), new Node("T1"))));

        // Step 2
        Function function = new Function(
            List.of(new Node("T1"), new Node("T2"), new Node("int"), new Node("T1")),
            new Node(List.of(new Node("T1"), new Node("T2")))
        );
        System.out.println(function.getReturnType(
            List.of(new Node("int"), new Node("string"), new Node("int"), new Node("int"))).returnType);
    }
}
