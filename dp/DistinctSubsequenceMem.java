// Distinct Subsequence using dp memoization
// Given two strings txt and pat. Find the count of distinct occurrences of pat in txt as a 
// sub-sequence modulo 109 + 7.

class DistinctSubsequenceMem {

    static int f(String s, String t, int i, int j, int[][] dp) {
        // returns no. of times t has occured in s till index i in s and j in t
        // using 1 based indexing
        if (j == 0) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }

        if(dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i-1) == t.charAt(j-1)) {
            return dp[i][j] = f(s, t, i - 1, j - 1, dp) + f(s, t, i - 1, j, dp);
        }

        return dp[i][j] = f(s, t, i - 1, j, dp);
    }

    static int subsequenceCount(String s, String t) {
        int n = s.length();
        int m = t.length();
        // create array for memoization
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++)
            for(int j=0; j<=m; j++)
                dp[i][j] = -1;

        return f(s, t, n, m, dp);
    }

    public static void main(String[] args) {
        String s = "banana";
        String t = "ban";

        System.out.println(subsequenceCount(s, t));
    }
}
