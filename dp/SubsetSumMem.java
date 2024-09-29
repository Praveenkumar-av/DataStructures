// Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set 
// with sum equal to given sum. 

import java.util.Arrays;

class SubsetSum {

    static int isSubsum(int[] arr, int x, int rem, int[][] dp) {
        if (x < 0 || rem <= 0) {
            return 0;
        }
        if (rem == arr[x]) {
            return 1;
        }

        if (dp[x][rem] != -1) {
            return dp[x][rem];
        }

        int pick = isSubsum(arr, x - 1, rem - arr[x], dp);
        int notpick = isSubsum(arr, x - 1, rem, dp);

        return dp[x][rem] = pick + notpick;
    }

    static Boolean isSubsetSum(int N, int arr[], int sum) {
        int[][] dp = new int[N][sum + 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        int result = isSubsum(arr, N - 1, sum, dp);
        if (result != 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int n = 6;
        int k = 9;
        System.err.println(isSubsetSum(n, arr, k));
    }
}
