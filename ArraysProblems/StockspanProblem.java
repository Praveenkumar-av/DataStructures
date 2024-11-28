// stock span problem

import java.util.*;

class StockspanProblem {

    static ArrayList<Integer> stockSpan(int[] arr) {
        int n = arr.length;

        ArrayDeque<Integer> st = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = 1;
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                sum += result.get(st.pop());
            }

            result.add(sum);
            st.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        // int[] arr = {100, 80, 60, 70, 60, 75, 85};
        int[] arr = {10, 4, 5, 90, 120, 80};

        System.out.println(stockSpan(arr));
    }
}
