package com.bala.pracrtice.ha;


import java.util.Arrays;
import java.util.Scanner;

public class MinMaxDiff {

    public static void main(String args[]) throws Exception {

        Scanner s = new Scanner(System.in);
        int noOfSteps = Integer.parseInt(s.nextLine());
        for (int i = 1; i <= noOfSteps; i++) {
            String[] mnStr = s.nextLine().split(" ");
            int n = Integer.parseInt(mnStr[0]);
            int m = Integer.parseInt(mnStr[1]);

            int nMinusM = n - m;
            int[] a = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            binarSort(a);
            int minSum = 0;
            int maxSum = 0;
            for (int j = 0; j < nMinusM; j++) {
                maxSum += a[n - j - 1];
                minSum += a[j];
            }
            System.out.println(maxSum - minSum);
        }

    }

    private static void binarSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            //Need to insert key into a[0,i-1] sorted array
            int j = i - 1;
            int location = abs(binarySearch(a, 0, i - 1, key));
            while (j >= location) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    private static int binarySearch(int[] sortedArr, int fromIndex, int toIndex, int key) {

        if (toIndex >= fromIndex) {
            int mid = (toIndex + fromIndex) / 2;
            int midVal = sortedArr[mid];

            if (midVal < key)
                return binarySearch(sortedArr, mid + 1, toIndex, key);
            else if (midVal > key)
                return binarySearch(sortedArr, fromIndex, mid - 1, key);
            else
                return mid;
        }
        return -fromIndex;

    }

    private static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            //Need to insert key into a[0,i-1] sorted array
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static int abs(int a) {
        return (a < 0) ? -a : a;
    }
}
