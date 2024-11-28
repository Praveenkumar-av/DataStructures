// Program to find the longest increasing subsequence using tabulation (backtracking)

import java.util.*;

class PrintLIS {

    static ArrayList<Integer> lis(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] track = new int[n];

        Arrays.fill(dp, 1);

        int maxInd = 0;  // first element
        int max = 1;  // first element
        for (int i = 1; i < n; i++) {
            track[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (arr[i] > arr[prev] && dp[prev] + 1 > dp[i]) {
                    // update and track the updated values
                        dp[i] = dp[prev] + 1;
                        track[i] = prev;
                }
            }
            // track the max index
            if(dp[i] > max){
                max = dp[i];
                maxInd = i;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        // backtrack to find the result
        int ptr = maxInd;
        result.add(arr[ptr]);
        while(ptr != track[ptr]) {
            ptr = track[ptr];
            result.add(arr[ptr]);
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2};
        // int[] arr = {10, 9, 2, 5, 3, 7, 101, 18}; 

        System.out.println(lis(arr));
    }
}
