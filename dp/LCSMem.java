// Longest Common Subsequence using recursion with memoization

import java.util.Arrays;
class LCSMem{
    static int f(String s1, String s2, int ind1, int ind2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }

        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + f(s1, s2, ind1 - 1, ind2 - 1, dp);
        }

        return dp[ind1][ind2] = Math.max(f(s1, s2, ind1 - 1, ind2, dp), f(s1, s2, ind1, ind2 - 1, dp));
    }

    // Function to find the length of longest common subsequence in two strings.
    static int lcs(int n, int m, String str1, String str2) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return f(str1, str2, n - 1, m - 1, dp);
    }

    public static void main(String[] args){
        String str1 = "XYZW", str2 = "XYWZ";
        int n = str1.length();
        int m = str2.length();

        int result = lcs(n, m, str1, str2);
        System.out.println(result);
    }
}