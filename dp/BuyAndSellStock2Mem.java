
class BuyAndSellStock2Mem {

    static int f(int[] prices, int ind, int buy, int[][] dp) {
        if (ind == prices.length) {
            return 0;
        }

        if(dp[ind][buy] != -1)
            return dp[ind][buy];

        if (buy == 0) {
            int take = -prices[ind] + f(prices, ind + 1, 1, dp);
            int notTake = f(prices, ind + 1, 0, dp);
            return dp[ind][buy] = Math.max(take, notTake);
        } else {
            int take = prices[ind] + f(prices, ind + 1, 0, dp);
            int notTake = f(prices, ind + 1, 1, dp);
            return dp[ind][buy] = Math.max(take, notTake);
        }
    }

    static int maximumProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i=0; i<n; i++)
            for(int j=0; j<2; j++)
                dp[i][j] = -1;

        return f(prices, 0, 0, dp);
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(maximumProfit(prices));
    }
}
