
class BuyAndSellStock3Mem {

    static int f(int[] prices, int ind, int buy, int count, int[][][] dp) {
        if (ind == prices.length || count > 2) {
            return 0;
        }
        if (dp[ind][buy][count] != -1) {
            return dp[ind][buy][count];
        }

        if (buy == 0) {  // not yet bought
            int take = -prices[ind] + f(prices, ind + 1, 1, count+1, dp);
            int notTake = f(prices, ind + 1, 0, count, dp);
            return dp[ind][buy][count] = Math.max(take, notTake);
        } else {
            int take = prices[ind] + f(prices, ind + 1, 0, count, dp);
            int notTake = f(prices, ind + 1, 1, count, dp);
            return dp[ind][buy][count] = Math.max(take, notTake);
        }
    }

    static int maximumProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return f(prices, 0, 0, 0, dp);
    }

    public static void main(String[] args) {
        int[] prices = {10, 22, 5, 75, 65, 80};
        // int[] prices = {2, 30, 15, 10, 8, 25, 80};

        System.out.println(maximumProfit(prices));
    }
}
