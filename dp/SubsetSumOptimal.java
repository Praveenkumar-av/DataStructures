// Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set 
// with sum equal to given sum. 

class SubsetSumOptimal {

    static boolean isSubsetSum(int n, int[] arr, int k) {
        boolean[] prev = new boolean[k + 1];
        // sum 0 is always true
        prev[0] = true;
        // first value is always true
        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }

        // traverse through the all the subset elements
        for (int i = 1; i < n; i++) {
            boolean[] temp = new boolean[k + 1];
            temp[0] = true;
            // compute for all the remainders
            for (int rem = 1; rem <= k; rem++) {
                boolean nottake = prev[rem];
                boolean take = false;
                if (arr[i] <= rem) {
                    take = prev[rem - arr[i]];
                }

                temp[rem] = nottake || take;
            }
            prev = temp;
        }

        return prev[k];
    }

    // Another approach
    static boolean isSubsetSum2(int n, int[] arr, int sum) {
        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;
        for (int val : arr) {
            for (int rem = sum; rem >= val; rem--) {
                dp[rem] = dp[rem] || dp[rem - val];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        // int[] arr = {1, 2, 4, 1};
        int n = arr.length;
        int k = 9;
        System.err.println(isSubsetSum(n, arr, k));
        System.err.println(isSubsetSum2(n, arr, k));
    }
}
