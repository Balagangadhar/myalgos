package com.bala.demo;

import java.util.Arrays;

public class OMergeSort<T extends Comparable<T>> {


    public void sort(T[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(A, p, q);
            sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }


    private void merge(T[] A, int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        Object L[] = new Object[n1 + 1];
        Object R[] = new Object[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        L[n1] = null;
        R[n2] = null;
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
        }

        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {

            T Li = (T) L[i];
            T Rj = (T) R[j];
            if (Rj == null || (Li != null && Li.compareTo(Rj) < 0)) {
                A[k] = Li;
                i++;
            } else {
                A[k] = Rj;
                j++;
            }
        }

    }

    public void print(T[] A) {
        if (A != null && A.length > 0) {
            Arrays.stream(A).forEach(k -> System.out.print(k + " - "));
        }
    }


}
