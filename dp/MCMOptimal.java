// Matrix chain Multiplication problem using dp (tabulation)

class MCMOptimal {

    static int mcm(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++)
            dp[i][i] = 0;

        for(int i=n-1; i >= 1 ; i--) {
            for(int j = i+1; j < n; j++) {
                int minSteps = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int steps = dp[i][k] // cost of left partition 
                            + dp[k + 1][j] // cost of right partition
                            + (arr[i - 1] * arr[k] * arr[j]);  // cost of mulitiplying left and right partition
                    minSteps = Math.min(minSteps, steps);
                }

                dp[i][j] = minSteps;
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("minimum no. of steps :" + mcm(arr));
    }
}
