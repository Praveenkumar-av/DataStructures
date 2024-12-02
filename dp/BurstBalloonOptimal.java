// Burst Ballon problem using dp(memoization)

import java.util.*;

class BurstBalloonOptimal {

    static int maxCoins(int[] nums) {
        ArrayList<Integer> arl = new ArrayList<>();
        int n = nums.length;

        for (int num : nums) {
            arl.add(num);
        }
        arl.addFirst(1);
        arl.add(1);

        int[][] dp = new int[n + 2][n + 2];

        for(int i=n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = arl.get(k) * arl.get(i - 1) * arl.get(j + 1)
                            + dp[i][k - 1]
                            + dp[k + 1][j];

                    max = Math.max(max, cost);
                }

                dp[i][j] = max;
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};

        System.out.println(maxCoins(nums));
    }
}
