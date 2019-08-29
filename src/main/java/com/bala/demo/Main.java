package com.bala.demo;


public class Main {

    public static void main(String[] args) {

//        testMergeSort();
        testOMergeSort();
    }

    public static void testMergeSort() {
        MergeSort msort = new MergeSort();
        int[] data = new int[]{2, 1, 3, 6, 9, 5, 4,};
        msort.sort(data, 0, data.length - 1);
        msort.print(data);
    }

    public static void testOMergeSort() {
        OMergeSort<String> msort = new OMergeSort();
        String[] data = new String[]{"a", "c", "b", "d", "ab", "bd", "ad"};
        msort.sort(data, 0, data.length - 1);
        msort.print(data);
    }
}
