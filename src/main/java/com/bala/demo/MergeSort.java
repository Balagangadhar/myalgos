package com.bala.demo;

import java.util.Arrays;

public class MergeSort {


    public void sort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(A, p, q);
            sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    private void merge(int[] A, int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1 + 1];
        int R[] = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        L[n1] = Integer.MAX_VALUE;

        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
        }
        R[n2] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] < R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }

    }

    public void print(int[] A) {
        if (A != null && A.length > 0) {
            Arrays.stream(A).forEach(k -> System.out.print(k + " - "));
        }
    }


}
