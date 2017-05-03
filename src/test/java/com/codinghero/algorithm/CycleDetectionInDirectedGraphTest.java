package com.codinghero.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class CycleDetectionInDirectedGraphTest {

    private CycleDetectionInDirectedGraph instance = new CycleDetectionInDirectedGraph();

    @Test
    public void test1() {
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
        Assert.assertTrue(instance.isCycleExisted(edges, 3));
    }

    @Test
    public void test2() {
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 1 } };
        Assert.assertTrue(instance.isCycleExisted(edges, 4));
    }

    @Test
    public void test3() {
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 3, 2 } };
        Assert.assertFalse(instance.isCycleExisted(edges, 4));
    }

    @Test
    public void test4() {
        int[][] edges = { { 0, 5 }, { 0, 15 }, { 0, 22 }, { 0, 46 }, { 0, 47 }, { 0, 48 }, { 0, 52 }, { 0, 53 },
                { 0, 62 }, { 0, 63 }, { 0, 74 }, { 0, 78 }, { 0, 79 }, { 0, 86 }, { 0, 88 }, { 0, 98 }, { 0, 99 },
                { 1, 2 }, { 1, 4 }, { 1, 5 }, { 1, 14 }, { 1, 21 }, { 1, 25 }, { 1, 29 }, { 1, 32 }, { 1, 37 },
                { 1, 38 }, { 1, 39 }, { 1, 40 }, { 1, 41 }, { 1, 43 }, { 1, 47 }, { 1, 56 }, { 1, 61 }, { 1, 68 },
                { 1, 71 }, { 1, 77 }, { 1, 82 }, { 1, 85 }, { 1, 86 }, { 1, 93 }, { 1, 98 }, { 1, 99 }, { 2, 5 },
                { 2, 7 }, { 2, 14 }, { 2, 20 }, { 2, 28 }, { 2, 33 }, { 2, 37 }, { 2, 39 }, { 2, 43 }, { 2, 49 },
                { 2, 51 }, { 2, 62 }, { 2, 70 }, { 2, 72 }, { 2, 74 }, { 2, 81 }, { 2, 91 }, { 2, 98 }, { 2, 99 },
                { 3, 5 }, { 3, 22 }, { 3, 23 }, { 3, 32 }, { 3, 37 }, { 3, 41 }, { 3, 50 }, { 3, 56 }, { 3, 62 },
                { 3, 63 }, { 3, 64 }, { 3, 68 }, { 3, 72 }, { 3, 73 }, { 3, 75 }, { 3, 83 }, { 3, 92 }, { 3, 93 },
                { 3, 95 }, { 3, 96 }, { 4, 6 }, { 4, 7 }, { 4, 8 }, { 4, 16 }, { 4, 17 }, { 4, 20 }, { 4, 22 },
                { 4, 25 }, { 4, 33 }, { 4, 36 }, { 4, 41 }, { 4, 46 }, { 4, 48 }, { 4, 52 }, { 4, 58 }, { 4, 65 },
                { 4, 74 }, { 4, 79 }, { 4, 85 }, { 4, 86 }, { 4, 88 }, { 5, 6 }, { 5, 10 }, { 5, 28 }, { 5, 29 },
                { 5, 33 }, { 5, 36 }, { 5, 43 }, { 5, 45 }, { 5, 47 }, { 5, 52 }, { 5, 55 }, { 5, 57 }, { 5, 72 },
                { 5, 73 }, { 5, 75 }, { 5, 81 }, { 5, 82 }, { 5, 88 }, { 5, 92 }, { 5, 96 }, { 5, 99 }, { 6, 8 },
                { 6, 9 }, { 6, 10 }, { 6, 13 }, { 6, 15 }, { 6, 22 }, { 6, 29 }, { 6, 36 }, { 6, 38 }, { 6, 39 },
                { 6, 41 }, { 6, 49 }, { 6, 50 }, { 6, 64 }, { 6, 69 }, { 6, 73 }, { 6, 75 }, { 6, 85 }, { 6, 88 },
                { 6, 89 }, { 6, 93 }, { 6, 96 }, { 6, 97 }, { 6, 98 }, { 7, 13 }, { 7, 20 }, { 7, 31 }, { 7, 33 },
                { 7, 46 }, { 7, 59 }, { 7, 65 }, { 7, 69 }, { 7, 73 }, { 7, 85 }, { 7, 86 }, { 7, 90 }, { 7, 92 },
                { 7, 93 }, { 7, 99 }, { 8, 11 }, { 8, 13 }, { 8, 17 }, { 8, 21 }, { 8, 26 }, { 8, 29 }, { 8, 36 },
                { 8, 37 }, { 8, 44 }, { 8, 47 }, { 8, 52 }, { 8, 57 }, { 8, 61 }, { 8, 69 }, { 8, 72 }, { 8, 78 },
                { 8, 79 }, { 8, 88 }, { 8, 89 }, { 8, 94 }, { 8, 96 }, { 9, 19 }, { 9, 24 }, { 9, 25 }, { 9, 30 },
                { 9, 40 }, { 9, 44 }, { 9, 48 }, { 9, 52 }, { 9, 57 }, { 9, 64 }, { 9, 69 }, { 9, 77 }, { 9, 95 },
                { 9, 96 }, { 10, 15 }, { 10, 20 }, { 10, 31 }, { 10, 32 }, { 10, 41 }, { 10, 49 }, { 10, 61 },
                { 10, 66 }, { 10, 69 }, { 10, 72 }, { 10, 74 }, { 10, 76 }, { 10, 85 }, { 10, 88 }, { 10, 90 },
                { 10, 95 }, { 10, 96 }, { 11, 12 }, { 11, 14 }, { 11, 20 }, { 11, 27 }, { 11, 31 }, { 11, 33 },
                { 11, 34 }, { 11, 41 }, { 11, 43 }, { 11, 44 }, { 11, 45 }, { 11, 46 }, { 11, 52 }, { 11, 53 },
                { 11, 59 }, { 11, 64 }, { 11, 67 }, { 11, 70 }, { 11, 77 }, { 11, 85 }, { 11, 89 }, { 11, 95 },
                { 11, 96 }, { 11, 98 }, { 12, 14 }, { 12, 19 }, { 12, 21 }, { 12, 24 }, { 12, 34 }, { 12, 35 },
                { 12, 47 }, { 12, 55 }, { 12, 56 }, { 12, 63 }, { 12, 71 }, { 12, 77 }, { 12, 82 }, { 12, 86 },
                { 12, 89 }, { 12, 91 }, { 12, 93 }, { 13, 17 }, { 13, 24 }, { 13, 37 }, { 13, 38 }, { 13, 40 },
                { 13, 44 }, { 13, 45 }, { 13, 47 }, { 13, 54 }, { 13, 60 }, { 13, 66 }, { 13, 73 }, { 13, 84 },
                { 13, 85 }, { 13, 87 }, { 13, 93 }, { 13, 96 }, { 13, 97 }, { 13, 98 }, { 14, 15 }, { 14, 22 },
                { 14, 24 }, { 14, 28 }, { 14, 29 }, { 14, 31 }, { 14, 40 }, { 14, 47 }, { 14, 50 }, { 14, 51 },
                { 14, 54 }, { 14, 60 }, { 14, 62 }, { 14, 66 }, { 14, 67 }, { 14, 70 }, { 14, 82 }, { 14, 84 },
                { 14, 97 }, { 15, 19 }, { 15, 20 }, { 15, 22 }, { 15, 24 }, { 15, 26 }, { 15, 28 }, { 15, 31 },
                { 15, 36 }, { 15, 40 }, { 15, 41 }, { 15, 43 }, { 15, 57 }, { 15, 63 }, { 15, 64 }, { 15, 65 },
                { 15, 73 }, { 15, 87 }, { 15, 95 }, { 16, 18 }, { 16, 23 }, { 16, 25 }, { 16, 28 }, { 16, 32 },
                { 16, 34 }, { 16, 35 }, { 16, 36 }, { 16, 47 }, { 16, 49 }, { 16, 50 }, { 16, 52 }, { 16, 57 },
                { 16, 71 }, { 16, 72 }, { 16, 74 }, { 16, 76 }, { 16, 78 }, { 16, 79 }, { 16, 81 }, { 17, 27 },
                { 17, 31 }, { 17, 32 }, { 17, 36 }, { 17, 41 }, { 17, 51 }, { 17, 55 }, { 17, 58 }, { 17, 61 },
                { 17, 62 }, { 17, 71 }, { 17, 74 }, { 17, 76 }, { 17, 79 }, { 17, 96 }, { 18, 20 }, { 18, 21 },
                { 18, 27 }, { 18, 29 }, { 18, 33 }, { 18, 38 }, { 18, 40 }, { 18, 47 }, { 18, 57 }, { 18, 58 },
                { 18, 65 }, { 18, 66 }, { 18, 67 }, { 18, 68 }, { 18, 70 }, { 18, 71 }, { 18, 77 }, { 18, 88 },
                { 18, 90 }, { 18, 95 }, { 19, 22 }, { 19, 35 }, { 19, 38 }, { 19, 40 }, { 19, 41 }, { 19, 45 },
                { 19, 49 }, { 19, 55 }, { 19, 57 }, { 19, 65 }, { 19, 66 }, { 19, 67 }, { 19, 73 }, { 19, 80 },
                { 19, 82 }, { 19, 83 }, { 19, 93 }, { 19, 96 }, { 19, 97 }, { 20, 26 }, { 20, 30 }, { 20, 35 },
                { 20, 38 }, { 20, 47 }, { 20, 52 }, { 20, 55 }, { 20, 57 }, { 20, 59 }, { 20, 60 }, { 20, 61 },
                { 20, 62 }, { 20, 76 }, { 20, 79 }, { 20, 81 }, { 20, 83 }, { 20, 96 }, { 21, 22 }, { 21, 37 },
                { 21, 52 }, { 21, 58 }, { 21, 61 }, { 21, 89 }, { 21, 91 }, { 21, 95 }, { 21, 99 }, { 22, 28 },
                { 22, 31 }, { 22, 34 }, { 22, 37 }, { 22, 40 }, { 22, 46 }, { 22, 47 }, { 22, 48 }, { 22, 49 },
                { 22, 51 }, { 22, 52 }, { 22, 53 }, { 22, 55 }, { 22, 60 }, { 22, 61 }, { 22, 65 }, { 22, 66 },
                { 22, 69 }, { 22, 87 }, { 22, 92 }, { 22, 98 }, { 23, 27 }, { 23, 31 }, { 23, 40 }, { 23, 41 },
                { 23, 48 }, { 23, 50 }, { 23, 52 }, { 23, 55 }, { 23, 67 }, { 23, 69 }, { 23, 75 }, { 23, 79 },
                { 23, 84 }, { 23, 88 }, { 23, 93 }, { 24, 25 }, { 24, 45 }, { 24, 48 }, { 24, 49 }, { 24, 51 },
                { 24, 54 }, { 24, 57 }, { 24, 66 }, { 24, 71 }, { 24, 76 }, { 24, 78 }, { 24, 86 }, { 24, 92 },
                { 24, 96 }, { 24, 98 }, { 25, 31 }, { 25, 33 }, { 25, 36 }, { 25, 42 }, { 25, 45 }, { 25, 55 },
                { 25, 61 }, { 25, 63 }, { 25, 64 }, { 25, 75 }, { 25, 79 }, { 25, 80 }, { 25, 89 }, { 25, 90 },
                { 25, 99 }, { 26, 33 }, { 26, 35 }, { 26, 38 }, { 26, 53 }, { 26, 86 }, { 26, 89 }, { 26, 93 },
                { 26, 99 }, { 27, 31 }, { 27, 35 }, { 27, 37 }, { 27, 39 }, { 27, 43 }, { 27, 50 }, { 27, 62 },
                { 27, 69 }, { 27, 73 }, { 27, 82 }, { 27, 85 }, { 27, 95 }, { 28, 31 }, { 28, 33 }, { 28, 38 },
                { 28, 43 }, { 28, 46 }, { 28, 53 }, { 28, 54 }, { 28, 55 }, { 28, 70 }, { 28, 75 }, { 28, 79 },
                { 28, 83 }, { 28, 87 }, { 28, 93 }, { 28, 96 }, { 28, 98 }, { 29, 35 }, { 29, 43 }, { 29, 46 },
                { 29, 51 }, { 29, 54 }, { 29, 56 }, { 29, 57 }, { 29, 67 }, { 29, 76 }, { 29, 78 }, { 29, 83 },
                { 29, 90 }, { 30, 32 }, { 30, 47 }, { 30, 49 }, { 30, 51 }, { 30, 56 }, { 30, 58 }, { 30, 59 },
                { 30, 61 }, { 30, 72 }, { 30, 74 }, { 30, 80 }, { 30, 88 }, { 30, 91 }, { 30, 95 }, { 31, 33 },
                { 31, 41 }, { 31, 42 }, { 31, 53 }, { 31, 54 }, { 31, 55 }, { 31, 63 }, { 31, 65 }, { 31, 73 },
                { 31, 76 }, { 31, 80 }, { 31, 83 }, { 31, 99 }, { 32, 55 }, { 32, 57 }, { 32, 59 }, { 32, 71 },
                { 32, 72 }, { 32, 73 }, { 32, 79 }, { 33, 34 }, { 33, 48 }, { 33, 64 }, { 33, 68 }, { 33, 75 },
                { 33, 80 }, { 33, 81 }, { 33, 86 }, { 33, 89 }, { 33, 91 }, { 33, 93 }, { 34, 39 }, { 34, 61 },
                { 34, 73 }, { 34, 74 }, { 34, 75 }, { 34, 76 }, { 34, 80 }, { 34, 81 }, { 34, 83 }, { 34, 88 },
                { 34, 99 }, { 35, 43 }, { 35, 48 }, { 35, 51 }, { 35, 56 }, { 35, 58 }, { 35, 77 }, { 35, 86 },
                { 35, 87 }, { 35, 89 }, { 35, 96 }, { 36, 37 }, { 36, 40 }, { 36, 50 }, { 36, 53 }, { 36, 55 },
                { 36, 57 }, { 36, 70 }, { 36, 71 }, { 36, 76 }, { 36, 93 }, { 37, 39 }, { 37, 47 }, { 37, 51 },
                { 37, 56 }, { 37, 70 }, { 37, 75 }, { 37, 84 }, { 37, 89 }, { 37, 91 }, { 37, 92 }, { 37, 95 },
                { 37, 97 }, { 38, 45 }, { 38, 46 }, { 38, 51 }, { 38, 53 }, { 38, 55 }, { 38, 56 }, { 38, 58 },
                { 38, 67 }, { 38, 80 }, { 38, 86 }, { 39, 43 }, { 39, 48 }, { 39, 49 }, { 39, 52 }, { 39, 55 },
                { 39, 63 }, { 39, 78 }, { 39, 80 }, { 39, 87 }, { 39, 88 }, { 39, 93 }, { 39, 94 }, { 39, 95 },
                { 39, 96 }, { 40, 43 }, { 40, 55 }, { 40, 56 }, { 40, 57 }, { 40, 64 }, { 40, 67 }, { 40, 69 },
                { 40, 79 }, { 40, 90 }, { 40, 94 }, { 40, 99 }, { 41, 43 }, { 41, 45 }, { 41, 46 }, { 41, 54 },
                { 41, 64 }, { 41, 65 }, { 41, 77 }, { 41, 79 }, { 41, 80 }, { 41, 81 }, { 41, 82 }, { 41, 84 },
                { 41, 88 }, { 41, 93 }, { 41, 95 }, { 41, 97 }, { 42, 47 }, { 42, 50 }, { 42, 51 }, { 42, 66 },
                { 42, 67 }, { 42, 72 }, { 42, 76 }, { 42, 85 }, { 42, 99 }, { 43, 46 }, { 43, 48 }, { 43, 53 },
                { 43, 54 }, { 43, 57 }, { 43, 59 }, { 43, 60 }, { 43, 61 }, { 43, 67 }, { 43, 69 }, { 43, 75 },
                { 43, 78 }, { 43, 81 }, { 43, 84 }, { 43, 85 }, { 43, 86 }, { 43, 87 }, { 43, 93 }, { 43, 95 },
                { 43, 96 }, { 44, 52 }, { 44, 56 }, { 44, 58 }, { 44, 59 }, { 44, 62 }, { 44, 66 }, { 44, 73 },
                { 44, 74 }, { 44, 82 }, { 44, 89 }, { 44, 93 }, { 44, 97 }, { 45, 46 }, { 45, 53 }, { 45, 57 },
                { 45, 58 }, { 45, 62 }, { 45, 64 }, { 45, 65 }, { 45, 66 }, { 45, 69 }, { 45, 75 }, { 45, 80 },
                { 45, 83 }, { 45, 94 }, { 45, 95 }, { 45, 98 }, { 45, 99 }, { 46, 54 }, { 46, 58 }, { 46, 64 },
                { 46, 65 }, { 46, 66 }, { 46, 68 }, { 46, 75 }, { 46, 76 }, { 46, 78 }, { 46, 80 }, { 46, 83 },
                { 46, 89 }, { 46, 90 }, { 47, 48 }, { 47, 55 }, { 47, 65 }, { 47, 70 }, { 47, 73 }, { 47, 95 },
                { 47, 98 }, { 48, 60 }, { 48, 61 }, { 48, 74 }, { 48, 77 }, { 48, 80 }, { 48, 84 }, { 48, 85 },
                { 48, 87 }, { 48, 96 }, { 49, 53 }, { 49, 67 }, { 49, 73 }, { 49, 79 }, { 49, 93 }, { 50, 58 },
                { 50, 67 }, { 50, 71 }, { 50, 79 }, { 50, 81 }, { 50, 82 }, { 50, 83 }, { 50, 90 }, { 50, 91 },
                { 50, 94 }, { 51, 53 }, { 51, 54 }, { 51, 57 }, { 51, 63 }, { 51, 69 }, { 51, 71 }, { 51, 75 },
                { 51, 81 }, { 51, 84 }, { 51, 95 }, { 52, 66 }, { 52, 77 }, { 52, 81 }, { 52, 83 }, { 52, 89 },
                { 52, 92 }, { 52, 94 }, { 52, 95 }, { 52, 99 }, { 53, 58 }, { 53, 66 }, { 53, 68 }, { 53, 72 },
                { 53, 77 }, { 53, 79 }, { 53, 88 }, { 53, 89 }, { 54, 55 }, { 54, 67 }, { 54, 78 }, { 54, 83 },
                { 54, 92 }, { 54, 94 }, { 54, 95 }, { 55, 63 }, { 55, 66 }, { 55, 77 }, { 55, 79 }, { 55, 80 },
                { 56, 59 }, { 56, 64 }, { 56, 65 }, { 56, 68 }, { 56, 80 }, { 56, 92 }, { 56, 93 }, { 57, 66 },
                { 57, 72 }, { 57, 75 }, { 57, 81 }, { 57, 85 }, { 57, 86 }, { 57, 87 }, { 57, 89 }, { 57, 96 },
                { 58, 59 }, { 58, 60 }, { 58, 61 }, { 58, 63 }, { 58, 75 }, { 58, 78 }, { 58, 81 }, { 58, 89 },
                { 58, 90 }, { 58, 99 }, { 59, 63 }, { 59, 65 }, { 59, 70 }, { 59, 81 }, { 59, 83 }, { 59, 88 },
                { 59, 89 }, { 59, 94 }, { 59, 98 }, { 59, 99 }, { 60, 61 }, { 60, 62 }, { 60, 63 }, { 60, 64 },
                { 60, 68 }, { 60, 74 }, { 60, 83 }, { 60, 86 }, { 60, 95 }, { 61, 62 }, { 61, 69 }, { 61, 70 },
                { 61, 71 }, { 61, 72 }, { 61, 79 }, { 61, 82 }, { 61, 92 }, { 61, 95 }, { 62, 64 }, { 62, 65 },
                { 62, 73 }, { 62, 78 }, { 62, 79 }, { 62, 83 }, { 62, 85 }, { 62, 86 }, { 62, 91 }, { 62, 95 },
                { 62, 99 }, { 63, 72 }, { 63, 87 }, { 63, 95 }, { 63, 96 }, { 63, 98 }, { 63, 99 }, { 64, 68 },
                { 64, 70 }, { 64, 72 }, { 64, 85 }, { 64, 88 }, { 64, 96 }, { 64, 97 }, { 64, 98 }, { 65, 68 },
                { 65, 69 }, { 65, 71 }, { 65, 82 }, { 65, 86 }, { 65, 94 }, { 65, 95 }, { 66, 85 }, { 66, 87 },
                { 66, 90 }, { 66, 95 }, { 66, 96 }, { 66, 97 }, { 67, 77 }, { 67, 81 }, { 67, 88 }, { 67, 91 },
                { 67, 99 }, { 68, 70 }, { 68, 74 }, { 68, 78 }, { 68, 79 }, { 68, 83 }, { 68, 89 }, { 68, 90 },
                { 68, 91 }, { 68, 98 }, { 69, 71 }, { 69, 72 }, { 69, 81 }, { 69, 93 }, { 69, 99 }, { 70, 74 },
                { 70, 77 }, { 70, 79 }, { 70, 85 }, { 70, 87 }, { 70, 88 }, { 71, 72 }, { 71, 76 }, { 71, 78 },
                { 71, 86 }, { 71, 97 }, { 72, 73 }, { 72, 78 }, { 72, 81 }, { 72, 86 }, { 72, 96 }, { 73, 76 },
                { 73, 91 }, { 73, 95 }, { 74, 80 }, { 74, 81 }, { 74, 85 }, { 74, 87 }, { 74, 90 }, { 74, 95 },
                { 74, 98 }, { 75, 81 }, { 76, 77 }, { 76, 86 }, { 76, 87 }, { 76, 92 }, { 77, 91 }, { 77, 93 },
                { 78, 79 }, { 78, 82 }, { 78, 83 }, { 78, 85 }, { 78, 89 }, { 78, 93 }, { 78, 94 }, { 78, 97 },
                { 79, 84 }, { 79, 87 }, { 79, 88 }, { 79, 92 }, { 79, 93 }, { 79, 97 }, { 79, 98 }, { 80, 81 },
                { 80, 90 }, { 81, 87 }, { 81, 93 }, { 82, 84 }, { 82, 90 }, { 82, 92 }, { 82, 94 }, { 82, 96 },
                { 83, 85 }, { 83, 92 }, { 84, 92 }, { 84, 93 }, { 84, 97 }, { 85, 96 }, { 85, 97 }, { 86, 87 },
                { 86, 99 }, { 87, 88 }, { 87, 89 }, { 87, 91 }, { 87, 94 }, { 87, 95 }, { 88, 95 }, { 89, 98 },
                { 90, 94 }, { 90, 97 }, { 91, 92 }, { 92, 95 }, { 92, 98 }, { 93, 95 }, { 94, 97 }, { 94, 98 },
                { 94, 99 }, { 95, 97 }, { 97, 98 } };
        Assert.assertFalse(instance.isCycleExisted(edges, 100));
    }
}
