class KnapSackOptimal {
    static int knapSack(int W, int[] wt, int[] val){
        int[] dp = new int[W+1];
        int n = val.length;
        for(int i=W; i >= wt[0]; i--)
            dp[i] = val[0];

        for(int i=0; i < n; i++){
            for(int rem = W; rem >= wt[i]; rem--){
                dp[rem] = Math.max(dp[rem], val[i] + dp[rem-wt[i]]);
            }
        }

        return dp[W];
    }

    public static void main(String[] args) {
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        int W = 4;

        int result = knapSack(W, wt, val);
        System.out.println(result);
    }
}