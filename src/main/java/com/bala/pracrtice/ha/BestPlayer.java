package com.bala.pracrtice.ha;

import java.util.Arrays;

public class BestPlayer {

    public static void main(String args[]) {

        //		Scanner s = new Scanner(System.in);
        //		int noOfElements = Integer.parseInt(s.nextLine());
        //		String[] vaccineMCountStr = s.nextLine().split(" ");
        //      String[] patientMCountStr = s.nextLine().sprlit(" ");

        BestPlayer mainClass = new BestPlayer();
        String[] vaccineMCountStr = new String[]{"123", "146", "454", "542", "456"};
        String[] patientMCountStr = new String[]{"100", "328", "248", "689", "200"};


        Integer[] vaccineMCountArr = mainClass.convertToIntegerArray(vaccineMCountStr);
        Integer[] patientMCountArr = mainClass.convertToIntegerArray(patientMCountStr);

        mainClass.binaryInsertionSort(vaccineMCountArr);
        

    }


    private <T extends Comparable<T>> void binaryInsertionSort(T[] a) {
        for (int i = 1; i < a.length; i++) {
            T key = a[i];
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

    private <T extends Comparable<T>> int binarySearch(T[] sortedArr, int fromIndex, int toIndex, T key) {

        if (toIndex >= fromIndex) {
            int mid = (toIndex + fromIndex) / 2;
            T midVal = sortedArr[mid];

            if (midVal.compareTo(key) < 0)
                return binarySearch(sortedArr, mid + 1, toIndex, key);
            else if (midVal.compareTo(key) > 0)
                return binarySearch(sortedArr, fromIndex, mid - 1, key);
            else
                return mid + 1;
        }
        return -fromIndex;

    }

    private <T extends Comparable<T>> void print(T[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public int abs(int pos) {
        return (pos < 0) ? -pos : pos;
    }


    public Integer[] convertToIntegerArray(String[] strArr) {
        return Arrays.stream(strArr).mapToInt(Integer::valueOf).boxed().toArray(Integer[]::new);

    }

    static class Fan implements Comparable<Fan> {
        private String name;
        private Integer fanQuotient;

        public Fan(String name, Integer fanQuotient) {
            this.name = name;
            this.fanQuotient = fanQuotient;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Fan fan = (Fan) o;

            if (!name.equals(fan.name)) return false;
            return fanQuotient.equals(fan.fanQuotient);
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + fanQuotient.hashCode();
            return result;
        }

        @Override
        public int compareTo(Fan o) {
            if (this.fanQuotient.compareTo(o.fanQuotient) == 0) {
                return this.name.compareTo(o.name);
            } else {
                return this.fanQuotient.compareTo(o.fanQuotient);
            }
        }
    }
}
