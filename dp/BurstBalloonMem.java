// Burst Ballon problem using dp(memoization)

import java.util.*;

class BurstBalloonMem {

    static int f(ArrayList<Integer> arl, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }

        if(dp[i][j] != -1)
            return dp[i][j];

        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = arl.get(k) * arl.get(i - 1) * arl.get(j + 1)
                    + f(arl, i, k - 1, dp)
                    + f(arl, k + 1, j, dp);

            max = Math.max(max, cost);
        }

        return dp[i][j] = max;
    }

    static int maxCoins(int[] nums) {
        ArrayList<Integer> arl = new ArrayList<>();
        int n = nums.length;

        for (int num : nums) {
            arl.add(num);
        }
        arl.addFirst(1);
        arl.add(1);

        // dp array for memoization
        int[][] dp = new int[n+2][n+2];
        for (int i = 0; i < n+2; i++) {
            for (int j = 0; j < n+2; j++) {
                dp[i][j] = -1;
            }
        }

        return f(arl, 1, n, dp);
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};

        System.out.println(maxCoins(nums));
    }
}
