package com.bala.pracrtice.ha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. Read input data as linked list and name it R
 * 2. Sort R
 * 3. Create empty linked list and name it L
 * 4. Iterate through R and do following operations
 * i : If Lmin == null move Rmin and Rmax to L
 * ii : ELse if Rmin < Lmin same as 4.i
 * iii: else move Rmax1, Rmax2 to L
 */
public class KingdomOfDreams {

	public static void main(String args[]) {

		//		Scanner s = new Scanner(System.in);
		//		int noOfElements = Integer.parseInt(s.nextLine());
		//		String[] vaccineMCountStr = s.nextLine().split(" ");
		//      String[] patientMCountStr = s.nextLine().sprlit(" ");

		KingdomOfDreams mainClass = new KingdomOfDreams();

		List<Integer> R = new ArrayList<>(Arrays.asList(300, 400, 600, 700));
		mainClass.binaryInsertionSort(R);
		List<Integer> L = new ArrayList<>(R.size());
		System.out.println(mainClass.computeCost(L, R));
	}

	private <T extends Comparable<T>> Integer computeCost(List<T> L, List<T> R) {
		Integer cost = 0;
		boolean rHasElements = true;
		while (rHasElements) {
			T Rmax = null;
			T Rmin = null;
			T Lmin = null;
			if (L.size() == 0) {
				Rmin = removeMin(R);
				L.add(Rmin);

				Rmax = removeMin(R);
				L.add(Rmax);
				cost = addToCost(cost, Rmax);
			} else {
				Lmin = getMin(L);
				Rmin = getMin(R);
				if (Rmin.compareTo(Lmin) < 0) {
					//Move Rmin & Rmax to L
					Rmin = removeMin(R);
					insertIntoSortedArray(L, Rmin);

					Rmax = removeMax(R);
					insertIntoSortedArray(L, Rmax);
					cost = addToCost(cost, Rmax);
				} else {
					Rmax = removeMax(R);
					insertIntoSortedArray(L, Rmax);
					cost = addToCost(cost, Rmax);

					Rmax = removeMax(R);
					insertIntoSortedArray(L, Rmax);
				}
			}

			if (R.size() == 0) {
				break;
			}
			Lmin = removeMin(L);
			insertIntoSortedArray(R, Lmin);
			cost = addToCost(cost, Lmin);

			rHasElements = R.size() > 0;
		}
		return cost;
	}

	private <T extends Comparable<T>> Integer addToCost(Integer cost, T t) {
		return t == null ? cost : cost + (Integer) t;
	}

	private <T extends Comparable<T>> T removeMin(List<T> list) {
		if (list == null || list.size() == 0) {
			return null;
		}
		return list.remove(0);
	}

	private <T extends Comparable<T>> T removeMax(List<T> list) {
		if (list == null || list.size() == 0) {
			return null;
		}
		return list.remove(list.size() - 1);
	}

	private <T extends Comparable<T>> T getMin(List<T> list) {
		return list.size() > 0 ? list.get(0) : null;
	}

	private <T extends Comparable<T>> T getMax(List<T> list) {
		return list.size() > 0 ? list.get(list.size() - 1) : null;
	}

	private <T extends Comparable<T>> void binaryInsertionSort(List<T> a) {

		for (int i = 1; i < a.size(); i++) {
			T key = a.get(i);
			insertIntoSortedArray(a, i, key);
		}
	}

	private <T extends Comparable<T>> void insertIntoSortedArray(List<T> a, T key) {
		if (key != null) {
			a.add(key);
			insertIntoSortedArray(a, a.size()-1, key);
		}
	}

	private <T extends Comparable<T>> void insertIntoSortedArray(List<T> a, int size, T key) {
		//Need to insert key into a[0,i-1] sorted array
		int j = size - 1;
		int location = abs(binarySearch(a, 0, size - 1, key));
		while (j >= location) {
			a.set(j + 1, a.get(j));
			j--;
		}
		a.set(j + 1, key);
	}

	private <T extends Comparable<T>> int binarySearch(List<T> sortedArr, int fromIndex, int toIndex, T key) {

		if (toIndex >= fromIndex) {
			int mid = (toIndex + fromIndex) / 2;
			T midVal = sortedArr.get(mid);

			if (midVal.compareTo(key) < 0)
				return binarySearch(sortedArr, mid + 1, toIndex, key);
			else if (midVal.compareTo(key) > 0)
				return binarySearch(sortedArr, fromIndex, mid - 1, key);
			else
				return mid + 1;
		}
		return -fromIndex;

	}

	private <T extends Comparable<T>> void print(List<T> a) {
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + " ");
		}
		System.out.println("");
	}

	public int abs(int pos) {
		return (pos < 0) ? -pos : pos;
	}

}
