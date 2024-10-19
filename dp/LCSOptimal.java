// Print the length if the Longest Common subsequence dp

class LCSOptimal{
    static int lcs(int n, int m, String s1, String s2){
        int[] prev = new int[m+1];
        int[] cur = new int[m+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    cur[j] = 1 + prev[j-1];
                else 
                    cur[j] = Math.max(prev[j], cur[j-1]);
            }
            prev = cur.clone();
        }

        return prev[m];
    }

    public static void main(String[] args) {
        // String str1 = "XYZW", str2 = "XYWZ";
        // String str1 = "aba";
        // String str2 = "aba";
        String str1 = "heap";
        String str2 = "Pea";
        int n = str1.length();
        int m = str2.length();

        int result = lcs(n, m, str1, str2);
        System.out.println(result);
    }
}