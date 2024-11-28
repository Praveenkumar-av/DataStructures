// Length of the longest increasing subsequence
import java.util.*;

class PrintLISBinarySearch {
    static int longIncSubsequence(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> arl = new ArrayList<>();
        arl.add(arr[0]);
        int len = 1;

        for (int i = 1; i<n; i++) {
            if (arr[i] > arl.get(len - 1)) {
                arl.add(arr[i]);
                len++;
            } else {
                int index = Collections.binarySearch(arl, arr[i]);
                if (index < 0) {
                    index = (-index) - 1;
                }
                arl.set(index, arr[i]);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        // int[] arr = {3, 10, 2, 1, 20};
        int[] arr = {50, 3, 10, 7, 40, 80};

        int n = arr.length;
        System.out.println(longIncSubsequence(arr));
    }
}