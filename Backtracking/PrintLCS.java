// Print Longest Common subsequence (single pattern) using Backtracking

class PrintLCS {

    static StringBuilder printLCS(int n, int m, String str1, String str2) {
        int[][] dp = new int[n+1][m + 1];

        // generate the tabulation of lcs
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j-1]; 
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // find the lcs string from the table
        int i=n, j=m;
        StringBuilder result = new StringBuilder();
        while(i>0 && j>0){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    result.append(str1.charAt(i-1));
                    i--;
                    j--;
                }
                else if(dp[i][j-1] > dp[i-1][j])
                    j--;
                else
                    i--;
        }

        return result.reverse();
    }

    public static void main(String[] args) {
        // String str1 = "XYZW", str2 = "XYWZ";
        // String str1 = "abaaa";
        // String str2 = "baabaca";
        String str1 = "bbabcbcab";
        String str2 = "bacbcbabb";
        int n = str1.length();
        int m = str2.length();

        StringBuilder result = printLCS(n, m, str1, str2);
        System.out.println(result);
    }
}