package com.codinghero.interview.openai;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class OrderProcessor {

    private final CustomerDao customerDao;

    private final OrderDao orderDao;

    private final ItemDao itemDao;

    public OrderProcessor(
        final CustomerDao customerDao,
        final OrderDao orderDao,
        final ItemDao itemDao) {
        this.customerDao = customerDao;
        this.orderDao = orderDao;
        this.itemDao = itemDao;
    }

    // TODO Long parameter list
    // TODO Vague exception
    public boolean processOrder(
        String orderId,
        String customerId,
        List<String> itemIds,
        List<Integer> quantities,
        String paymentMethod,
        String email) throws Exception {

        if (!validate(orderId, itemIds, quantities)) {
            return false;
        }
        final Map<String, Integer> itemQuantities = getItemQuantities(itemIds, quantities);
        final List<Item> items = itemDao.getItemsByIds(itemIds);

        if (!validateQuantities(items, itemQuantities)) {
            return false;
        }

        // Get customer type
        Optional<Customer> optionalCustomer = customerDao.getCustomerById(customerId);
        if (optionalCustomer.isEmpty()) {
            System.out.println("Customer not found: " + customerId);
            return false;
        }
        Customer customer = optionalCustomer.get();

        // Get total price and apply discount
        double totalPrice = getTotalPrice(items, itemQuantities, customer);

        // Process payment
        if (!isPaymentSuccess(paymentMethod, totalPrice)) {
            return false;
        }

        // Update inventory
        itemDao.updateInventory(itemQuantities);

        // Save order to database
        Order order = new Order(orderId, customerId, totalPrice);
        orderDao.saveOrder(order);

        // TODO separate
        // Send email notification
        sendEmailNotification(order, email);

        return true;
    }

    private double getTotalPrice(
        List<Item> items,
        Map<String, Integer> itemQuantities,
        Customer customer) {
        double totalPrice = items.stream()
            .map(item -> item.price() * itemQuantities.get(item.itemId()))
            .reduce(0.0, Double::sum);
        // Polymorphism. Get the rate by corresponding Enum/Object
        if (customer.customerType().equals("PREMIUM")) {
            totalPrice = totalPrice * 0.9; // 10% discount
        } else if (customer.customerType().equals("VIP")) {
            totalPrice = totalPrice * 0.8; // 20% discount
        }
        return totalPrice;
    }

    private void sendEmailNotification(Order order, String email) {
        if (email != null && !email.isEmpty()) {
            System.out.println("Sending email to: " + email);
            System.out.println("Subject: Order Confirmation - " + order.orderId());
            System.out.println("Dear Customer,");
            System.out.println(
                "Your order " + order.orderId() + " has been processed successfully.");
            System.out.println("Total amount: $" + order.totalPrice());
            System.out.println("Thank you for your purchase!");
        }
    }

    private boolean isPaymentSuccess(String paymentMethod, double totalPrice) {
        if (paymentMethod.equals("CREDIT_CARD")) {
            // Simulate credit card processing
            System.out.println("Processing credit card payment of $" + totalPrice);
            return true;
        } else if (paymentMethod.equals("PAYPAL")) {
            // Simulate PayPal processing
            System.out.println("Processing PayPal payment of $" + totalPrice);
            return true;
        } else if (paymentMethod.equals("BITCOIN")) {
            // Simulate Bitcoin processing
            System.out.println("Processing Bitcoin payment of $" + totalPrice);
            return true;
        } else {
            System.out.println("Invalid payment method");
            return false;
        }
    }

    private boolean validateQuantities(List<Item> items, Map<String, Integer> itemQuantities) {
        for (final Item item : items) {
            final Integer quantity = itemQuantities.get(item.itemId());
            if (quantity != null && item.stock() < quantity) {
                System.out.println("Insufficient stock for item: " + item.itemId());
                return false;
            }
        }
        return true;
    }

    private Map<String, Integer> getItemQuantities(List<String> itemIds, List<Integer> quantities) {
        Map<String, Integer> itemQuantities = new HashMap<>();
        for (int i = 0; i < itemIds.size(); i++) {
            itemQuantities.put(itemIds.get(i), quantities.get(i));
        }
        return itemQuantities;
    }

    private boolean validate(
        String orderId,
        List<String> itemIds,
        List<Integer> quantities) {
        if (orderId == null || orderId.isEmpty()) {
            System.out.println("Invalid order ID");
            return false;
        }
        if (itemIds == null || itemIds.isEmpty()) {
            System.out.println("No items in order");
            return false;
        }
        if (itemIds.size() != quantities.size()) {
            System.out.println("Items and quantities mismatch");
            return false;
        }
        return true;
    }

    private static class OrderDao {

        private Connection dbConnection;

        private void saveOrder(Order order) throws SQLException {
            Statement orderStmt = dbConnection.createStatement();
            orderStmt.executeUpdate(
                "INSERT INTO orders (id, customer_id, total_price, status) VALUES ('" +
                    order.orderId() + "', '" + order.customerId() + "', " + order.totalPrice()
                    + ", 'COMPLETED')");
            orderStmt.close();
        }
    }

    private static class ItemDao {

        private Connection dbConnection;

        public List<Item> getItemsByIds(List<String> itemIds) throws SQLException {
            final List<Item> items = new ArrayList<>();
            for (String itemId : itemIds) {
                // TODO Separate data access and business logic
                Statement stmt = dbConnection.createStatement();
                ResultSet rs = stmt.executeQuery(
                    "SELECT price, stock FROM items WHERE id = '" + itemId + "'");

                if (rs.next()) {
                    double price = rs.getDouble("price");
                    int stock = rs.getInt("stock");

                    items.add(new Item(itemId, price, stock));

                }
                rs.close();
                stmt.close();
            }
            return items;
        }

        public void updateInventory(Map<String, Integer> itemQuantities) throws SQLException {
            for (final Entry<String, Integer> itemQuantity : itemQuantities.entrySet()) {
                Statement updateStmt = dbConnection.createStatement();
                updateStmt.executeUpdate(
                    "UPDATE items SET stock = stock - " + itemQuantity.getValue() +
                        " WHERE id = '" + itemQuantity.getKey() + "'");
                updateStmt.close();
            }
        }
    }

    private static class CustomerDao {

        private Connection dbConnection;

        private Optional<Customer> getCustomerById(String customerId) throws SQLException {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT customer_type FROM customers WHERE id = '" + customerId + "'");
            Customer customer = null;
            if (rs.next()) {
                customer = new Customer(customerId, rs.getString("customer_type"));
            }
            rs.close();
            stmt.close();
            return Optional.ofNullable(customer);
        }
    }


    private record Order(String orderId, String customerId, double totalPrice) {

    }

    private record Customer(String customerId, String customerType) {

    }

    private record Item(String itemId, double price, int stock) {

    }
}
