// Given an array arr of size n of non-negative integers and an integer sum, 
// the task is to count all subsets of the given array with a sum equal to a given sum.

class PerfectSumOptimal{
    static int countSubsetSum(int[] arr, int n, int k){
        int[] dp = new int[k + 1];

        dp[0] = 1;

        int MOD = 1000000007;

        for (int val : arr) 
            for (int rem = k; rem >= val; rem--) 
                dp[rem] = (dp[rem] + dp[rem - val]) % MOD;

        return dp[k];
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 0, 3, 9, 8, 6, 5, 7, 6};
        int n = arr.length;
        int k = 31;
        System.err.println(countSubsetSum(arr, n, k));
    }
}