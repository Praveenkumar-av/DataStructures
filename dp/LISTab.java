// Program to find the longest increasing subsequence using tabulation

import java.util.Arrays;

class LISTab {

    // 2d tabulation
    static int lisTab(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prev_ind = ind; prev_ind >= -1; prev_ind--) {
                int take = 0;
                if (prev_ind == -1 || arr[ind] > arr[prev_ind]) {
                    take = 1 + dp[ind + 1][ind + 1];
                }
                int notTake = dp[ind + 1][prev_ind + 1];
                dp[ind][prev_ind + 1] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    }

    // 1D array
    static int lis(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int result = 1;  // first element

        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (arr[i] > arr[prev]) {
                    dp[i] = Math.max(dp[prev] + 1, dp[i]);
                    result = Math.max(result, dp[i]);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 12, 3};
        // int[] arr = {1, 11, 2, 10, 4, 5, 2, 1}; 

        System.out.println(lis(arr));
    }
}
