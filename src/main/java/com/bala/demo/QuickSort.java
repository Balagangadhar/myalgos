package com.bala.demo;

import java.util.Arrays;

public class QuickSort {


    public void sort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            sort(A, p, q);
//            sort(A, q + 1, r);
        }
    }

    private int partition(int[] A, int p, int r) {
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= A[r]) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, r);
        return i + 1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    public void print(int[] A) {
        if (A != null && A.length > 0) {
            Arrays.stream(A).forEach(k -> System.out.print(k + " - "));
        }
    }


}
