// Coin Change (count ways)

class CoinChange {
    static int countWays(int[] coins, int target) {
        int n = coins.length;
        int[] dp = new int[target+1];
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

        int result = countWays(coins, target);
        System.out.println(result);
    }
}