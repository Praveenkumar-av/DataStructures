// Matrix chain Multiplication problem using dp(memoization)

class MCMmem {

    static int f(int[] arr, int i, int j, int[][] dp) {
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int minSteps = (int) 1e9;
        for (int k = i; k <= j - 1; k++) {
            int steps = f(arr, i, k, dp) // cost of left partition 
                    + f(arr, k + 1, j, dp) // cost of right partition
                    + (arr[i - 1] * arr[k] * arr[j]);  // cost of mulitiplying left and right partition
            minSteps = Math.min(minSteps, steps);
        }

        return dp[i][j] = minSteps;
    }

    static int mcm(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return f(arr, 1, n - 1, dp);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("minimum no. of steps :" + mcm(arr));
    }
}
