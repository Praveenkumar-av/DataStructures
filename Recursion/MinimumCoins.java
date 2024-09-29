// Coin Change (Minimum coins)
// We are given a target sum of ‘X’ and ‘N’ distinct numbers denoting the coin denominations. 
// We need to tell the minimum number of coins required to reach the target sum. We can pick 
// a coin denomination for any number of times we want.

class MinimumCoins {
    static int f(int[] coins, int target, int ind){
        if(ind == 0)
            if(target%coins[0] == 0)
                return target/coins[0];
            else 
                return Integer.MAX_VALUE;

        int nottake = f(coins, target, ind-1);
        int take = Integer.MAX_VALUE;
        if(coins[ind] <= target)
            take = 1 + f(coins, target-coins[ind], ind);
        
        return Math.min(take, nottake);
    }
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int n = coins.length;
        int target = 4;

        int result = f(coins, target, n-1);
        System.out.println(result);
    }
}