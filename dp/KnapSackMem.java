// Knapsack problem in java using recursion

import java.util.Arrays;

class KnapSackMem {
    static int maxCapacity(int w, int[] wt, int[] val, int ind, int[][] dp) {
        if (ind == 0) {
            if (wt[0] <= w) {
                return val[0]; 
            }else {
                return 0;
            }
        }

        if (dp[ind][w] != -1) {
            return dp[ind][w];
        }

        int pick = 0;
        if (w >= wt[ind]) {
            pick = val[ind] + maxCapacity(w - wt[ind], wt, val, ind - 1, dp);
        }

        int notpick = maxCapacity(w, wt, val, ind - 1, dp);

        return dp[ind][w] = Math.max(pick, notpick);
    }

    static int knapSack(int W, int wt[], int val[]) {
        int n = wt.length;
        int[][] dp = new int[n][W + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return maxCapacity(W, wt, val, n - 1, dp);
    }

    public static void main(String[] args) {
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        int W = 4;

        int result = knapSack(W, wt, val);
        System.out.println(result);
    }
}
