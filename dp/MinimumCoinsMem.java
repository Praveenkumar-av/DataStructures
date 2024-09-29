// Coin Change (Minimum coins)
// We are given a target sum of ‘X’ and ‘N’ distinct numbers denoting the coin denominations. 
// We need to tell the minimum number of coins required to reach the target sum. We can pick a 
// coin denomination for any number of times we want.

import java.util.Arrays;
class MinimumCoinsMem {
    static int f(int[] coins, int target, int ind, int[][] dp) {
        if (ind == 0) {
            if (target % coins[0] == 0) {
                return target / coins[0]; 
            }else {
                return (int)Math.pow(10, 9);
            }
        }

        if(dp[ind][target] != -1)
            return dp[ind][target];

        int nottake = f(coins, target, ind - 1, dp);
        int take = (int)Math.pow(10, 9);
        if (coins[ind] <= target) {
            take = 1 + f(coins, target - coins[ind], ind, dp);
        }

        return dp[ind][target] = Math.min(take, nottake);
    }

    public static void main(String[] args) {
        // int[] coins = {1, 2, 3};
        int[] coins = {25, 10, 5};
        int n = coins.length;
        int target = 30;

        int[][] dp = new int[n][target+1];
        for(int i = 0; i<n; i++)    
            Arrays.fill(dp[i], -1);

        int result = f(coins, target, n - 1, dp);
        System.out.println(result);
    }
}