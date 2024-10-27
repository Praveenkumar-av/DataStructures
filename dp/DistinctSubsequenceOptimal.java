// Distinct Subsequence using Recursion
// Given two strings txt and pat. Find the count of distinct occurrences of pat in txt as a 
// sub-sequence modulo 109 + 7.

class DistinctSubsequenceOptimal {

    static int subsequenceCount(String s, String t) {
        int n = s.length();
        int m = t.length();
        int MOD = (int) 1e9 + 7;

        int[] dp = new int[m + 1];
        dp[0] = 1;

        // assuming 1 based indexing
        for (int i = 1; i <= n; i++) {
            for (int j = m; j > 0; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = (dp[j - 1] + dp[j]) % MOD;
                }
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {
        String s = "banana";
        String t = "ban";

        System.out.println(subsequenceCount(s, t));
    }
}
