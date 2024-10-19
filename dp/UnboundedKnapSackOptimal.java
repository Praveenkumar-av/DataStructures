// Unbounded knapsack problem

class UnboundedKnapSackOptimal {

    static int knapSack(int N, int W, int val[], int wt[]) {
        int[] dp = new int[W + 1];

        for (int i = 0; i < N; i++) {
            for (int rem = wt[i]; rem <= W; rem++) {
                dp[rem] = Math.max(dp[rem], val[i] + dp[rem - wt[i]]);
            }
        }

        return dp[W];
    }

    public static void main(String args[]) {
        int[] val = {6, 1, 7, 7};
        int[] wt = {1, 3, 4, 5};
        int w = 8;

        System.out.println(knapSack(val.length, w, val, wt));
    }
}
