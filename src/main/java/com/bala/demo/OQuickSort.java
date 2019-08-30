package com.bala.demo;

import java.util.Arrays;

public class OQuickSort<T extends Comparable<T>> {

	public void sort(T[] A, int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			sort(A, p, q - 1);
			sort(A, q + 1, r);
		}
	}

	private int partition(T[] A, int p, int r) {
		int i = p - 1;
		for (int j = p; j <= r - 1; j++) {
			if (A[j].compareTo(A[r]) < 1) {
				i++;
				swap(A, i, j);
			}
		}
		swap(A, i + 1, r);
		return i + 1;
	}

	private void swap(T[] A, int i, int j) {
		T temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public void print(T[] A) {
		if (A != null && A.length > 0) {
			Arrays.stream(A).forEach(k -> System.out.print(k + " - "));
		}
	}

}
