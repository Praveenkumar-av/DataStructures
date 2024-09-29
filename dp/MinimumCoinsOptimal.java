// Coin Change (Minimum coins)
// We are given a target sum of ‘X’ and ‘N’ distinct numbers denoting the coin denominations. 
// We need to tell the minimum number of coins required to reach the target sum. We can pick a 
// coin denomination for any number of times we want.

import java.util.Arrays;
class MinimumCoinsOptimal {

    static int f(int[] coins, int target) {
        int n = coins.length;
        int[] dp = new int[target+1];
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int rem = coins[i]; rem <= target; rem++) {
                dp[rem] = Math.min(dp[rem], 1 + dp[rem - coins[i]]);
            }
        }

        return dp[target];
    }

    static int f2(int[] coins, int target) {
        int n = coins.length;
        int[] dp = new int[target+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int rem = coins[i]; rem <= target; rem++) {
                dp[rem] = dp[rem] + dp[rem - coins[i]];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int target = 4;

        int result = f2(coins, target);
        System.out.println(result);
    }
}
