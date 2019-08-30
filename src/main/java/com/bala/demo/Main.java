package com.bala.demo;

public class Main {

	public static void main(String[] args) {

		//        testMergeSort();
		//        testOMergeSort();
		//        testOMergeSortInt();
		testOQuickSort();
	}

	private static void testOQuickSort() {
		OQuickSort msort = new OQuickSort();
		Integer[] data = new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 };
		msort.sort(data, 0, data.length - 1);
		msort.print(data);
	}

	private static void testQuickSort() {
		QuickSort msort = new QuickSort();
		int[] data = new int[] { 8, 7, 6, 5, 4, 3, 2, 1 };
		msort.sort(data, 0, data.length - 1);
		msort.print(data);
	}

	public static void testMergeSort() {
		MergeSort msort = new MergeSort();
		int[] data = new int[] { 2, 1, 3, 6, 9, 5, 4, };
		msort.sort(data, 0, data.length - 1);
		msort.print(data);
	}

	public static void testOMergeSort() {
		OMergeSort<String> msort = new OMergeSort();
		String[] data = new String[] { "a", "c", "b", "d", "ab", "bd", "ad" };
		msort.sort(data, 0, data.length - 1);
		msort.print(data);
	}

	public static void testOMergeSortInt() {
		OMergeSort<Integer> msort = new OMergeSort();
		Integer[] data = new Integer[] { 2, 1, 3, 6, 9, 5, 4, };
		msort.sort(data, 0, data.length - 1);
		msort.print(data);
	}
}
