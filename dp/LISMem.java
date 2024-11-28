// Program to find the longest increasing subsequence using recursion with memoization

class LISMem {

    static int f(int[] arr, int ind, int prev_ind, int[][] dp) {
        if (ind < 0) {
            return 0;
        }

        // prev_ind + 1 to avoid negative index -1
        if(dp[ind][prev_ind+1] != -1)   
            return dp[ind][prev_ind+1];

        int take = 0;
        if (prev_ind == -1 || arr[ind] < arr[prev_ind]) {
            take = 1 + f(arr, ind - 1, ind, dp);
        }
        int notTake = f(arr, ind - 1, prev_ind, dp);

        return  dp[ind][prev_ind+1] = Math.max(take, notTake);
    }

    static int lis(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n+1];
        for(int i=0; i<n; i++)
            for(int j=0; j<=n; j++)
                dp[i][j] = -1;

        return f(arr, n - 1, -1, dp);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 12};
        // int[] arr = {10, 9, 2, 5, 3, 7, 101, 18}; 

        System.out.println(lis(arr));
    }
}
