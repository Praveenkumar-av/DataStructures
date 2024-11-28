class BuyAndSellStock2 {
    static int f(int[] prices, int ind, int buy){
        if(ind == prices.length)
            return 0;
        
        if(buy == 0) {
            int take = -prices[ind] + f(prices, ind+1, 1);
            int notTake = f(prices, ind+1, 0);
            return Math.max(take, notTake);
        }
        else {
            int take = prices[ind] + f(prices, ind+1, 0);
            int notTake = f(prices, ind+1, 1);
            return Math.max(take, notTake);
        }
    }

    static int maximumProfit(int[] prices){
        return f(prices, 0, 0);
    }
    
    public static void main(String[] args){
        
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(maximumProfit(prices));
    }
}