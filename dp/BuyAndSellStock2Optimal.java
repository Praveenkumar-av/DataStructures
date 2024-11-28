class BuyAndSellStock2Optimal {
    // tabulation
    static int maximumProfitTab(int[] prices) {
        int n = prices.length;
        
        int[][] dp = new int[n+1][2];

        for(int i=n-1; i>=0; i--){
            dp[i][0] = Math.max(-prices[i] + dp[i+1][1], dp[i+1][0]);
            dp[i][1] = Math.max(prices[i] + dp[i+1][0], dp[i+1][1]);
        }

        return dp[0][0];
    }

    // constant space
    static int maximumProfit(int[] prices) {
        int n = prices.length;

        int[] front = new int[2];
        int[] cur = new int[2];

        for (int i = n - 1; i >= 0; i--) {
            cur[0] = Math.max(-prices[i] + front[1], front[0]);
            cur[1] = Math.max(prices[i] + front[0], front[1]);
            System.out.println(cur[0]+ " "+cur[1]);
            front = cur.clone();
        }

        return front[0];
    }

    public static void main(String[] args) {
        // int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {10, 22, 5, 75, 65, 80};

        System.out.println(maximumProfit(prices));
    }
}