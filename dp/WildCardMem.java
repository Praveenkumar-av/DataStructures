// wildcard pattern matching using dp memoization

class WildCardMem {
    // 1 based indexing
    static int f(String s1, String s2, int i, int j, int[][] dp) {
        if (i == 0 && j == 0)   
            return 1;
        
        if (i == 0) 
            return 0;
        
        if (j == 0)
            if(s1.charAt(i-1) == '*')
                return f(s1, s2, i-1, j,dp);
            else    
                return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i-1) == '?' || s1.charAt(i-1) == s2.charAt(j-1)) 
            return dp[i][j] = f(s1, s2, i - 1, j - 1, dp);

        if (s1.charAt(i-1) == '*') 
            return dp[i][j] = f(s1, s2, i - 1, j, dp) + f(s1, s2, i - 1, j - 1, dp) + f(s1, s2, i, j - 1, dp);

        return 0;
    }

    static int wildCard(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++)
            for(int j=0; j<=m; j++)
                dp[i][j] = -1;

        if(f(s1, s2, n, m, dp) > 0)
            return 1;
        
        return 0;
    }
/*
    // 0 based indexing
    static int f(String s1, String s2, int i, int j, int[][] dp) {
        if (i == -1 && j == -1) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if(j < 0)
            if(s1.charAt(i) == '*')
                return f(s1, s2, i-1, j,dp);
            else    
                return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == '?' || s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = f(s1, s2, i - 1, j - 1, dp);
        }

        if (s1.charAt(i) == '*') {
            return dp[i][j] = f(s1, s2, i - 1, j, dp) + f(s1, s2, i - 1, j - 1, dp) + f(s1, s2, i, j - 1, dp);
        }

        return 0;
    }

    static int wildCard(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                dp[i][j] = -1;

        if(f(s1, s2, n - 1, m - 1, dp) > 0)
            return 1;
        
        return 0;
    }
*/
    public static void main(String[] args) {
        // String s1 = "ba*a?";
        // String s2 = "baaabab";
        String s1 = "*ccddee*";
        String s2 = "ccddee";

        System.out.println(wildCard(s1, s2));
    }
}
