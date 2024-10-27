// wildcard pattern matching using tabulation

class WildCardOptimal {

    // Tabulation
    static boolean wildCardTab(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            if (s1.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }

            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == '?' || s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (s1.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 1] || dp[i][j - 1];
                }
                else
                    dp[i][j] = false;
            }
        }
        return dp[n][m];
    }

    // 1D array
    static boolean wildCard(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        boolean[] prev = new boolean[m + 1];
        boolean[] cur = new boolean[m + 1];
        prev[0] = true;

        for (int i = 1; i <= n; i++) {
            if (s1.charAt(i - 1) == '*') {
                cur[0] = prev[0];
            }

            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == '?' || s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cur[j] = prev[j - 1];
                }
                else if (s1.charAt(i - 1) == '*') {
                    cur[j] = prev[j] || prev[j - 1] || cur[j - 1];
                }
                else
                    cur[j] = false;
            }
            prev = cur.clone();
        }
        return prev[m];
    }

    public static void main(String[] args) {
        // String s1 = "ba*a?";
        // String s2 = "baaabab";
        String s1 = "*ccddee*";
        String s2 = "ccddee";

        System.out.println(wildCard(s1, s2));
    }
}
