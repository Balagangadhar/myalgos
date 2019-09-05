package com.bala.pracrtice.ha;

public class IndexingSortedArray {

    public static void main(String args[]) {

        //		Scanner s = new Scanner(System.in);
        //		int noOfElements = Integer.parseInt(s.nextLine());
        //		String[] strArray = s.nextLine().split(" ");

        String[] strArray = new String[]{"2", "2", "1"};
        Node[] nodes = new Node[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            nodes[i] = new Node(Integer.parseInt(strArray[i]), i);
        }

        binarySort(nodes);
        print(nodes);
        for (int i = 0; i < nodes.length; i++) {
            System.out.print(nodes[i].index + " ");
        }
    }

    private static void binarySort(Node[] a) {
        for (int i = 1; i < a.length; i++) {
            Node key = a[i];
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

    private static int binarySearch(Node[] sortedArr, int fromIndex, int toIndex, Node key) {

        if (toIndex >= fromIndex) {
            int mid = (toIndex + fromIndex) / 2;
            Node midVal = sortedArr[mid];

            if (midVal.compareTo(key) < 0)
                return binarySearch(sortedArr, mid + 1, toIndex, key);
            else if (midVal.compareTo(key) > 0)
                return binarySearch(sortedArr, fromIndex, mid - 1, key);
            else
                return mid + 1;
        }
        return -fromIndex;

    }

    private static void print(Node[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i].num + " ");
        }
        System.out.println("");
    }

    public static int abs(int a) {
        return (a < 0) ? -a : a;
    }

    static class Node implements Comparable<Node> {
        private Integer num;
        private Integer index;

        public Node(Integer num, Integer index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return this.num.compareTo(o.num);
        }
    }
}
