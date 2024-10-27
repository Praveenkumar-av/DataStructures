// Edit distance problem using dp memoization
// Given two strings str1 and str2. Return the minimum number of operations required to convert str1 to str2.
// The possible operations are permitted:
//     1.Insert a character at any position of the string.
//     2.Remove any character from the string.
//     3.Replace any character from the string with any other character.

class EditDistanceMem {

    static int f(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }

        if(dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = f(s1, s2, i - 1, j - 1, dp);  // if both the character matches
        }
        int in = 1 + f(s1, s2, i, j - 1, dp);  // insert the character in s1
        int del = 1 + f(s1, s2, i - 1, j, dp); // delete
        int rep = 1 + f(s1, s2, i - 1, j - 1, dp); // replace

        return dp[i][j] = Math.min(in, Math.min(del, rep));
    }

    static int editDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++)
            for(int j=0; j<=m; j++)
                dp[i][j] = -1;

        return f(s1, s2, n - 1, m - 1, dp);
    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        int result = editDistance(s1, s2);
        System.out.println(result);
    }
}
