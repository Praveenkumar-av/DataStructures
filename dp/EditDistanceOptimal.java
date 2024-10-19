// Edit distance problem using resursion
// Given two strings str1 and str2. Return the minimum number of operations required to convert str1 to str2.
// The possible operations are permitted:
//     1.Insert a character at any position of the string.
//     2.Remove any character from the string.
//     3.Replace any character from the string with any other character.

class EditDistanceOptimal { 
    // Tabulation
    static int editDistanceTab(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
            }
        }

        return dp[n][m];
    }

    // 1D array
    static int editDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }

        for(int i=1; i<=n; i++){
            cur[0] = i;
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    cur[j] = prev[j-1];
                else
                    cur[j] = 1 + Math.min(cur[j-1], Math.min(prev[j], prev[j-1]));
            }
            prev = cur.clone();
        }

        return prev[m];
    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        int result = editDistance(s1, s2);
        System.out.println(result);
    }
}
