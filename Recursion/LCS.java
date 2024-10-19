// Longest Common Subsequence using recursion 

class LCS {

    static int f(String s1, String s2, int ind1, int ind2) {
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }
        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return 1 + f(s1, s2, ind1 - 1, ind2 - 1);
        }

        return Math.max(f(s1, s2, ind1 - 1, ind2), f(s1, s2, ind1, ind2 - 1));
    }

    // Function to find the length of longest common subsequence in two strings.
    static int lcs(int n, int m, String str1, String str2) {

        return f(str1, str2, n - 1, m - 1);
    }

    public static void main(String[] args) {
        String str1 = "XYZW", str2 = "XYWZ";
        int n = str1.length();
        int m = str2.length();

        int result = lcs(n, m, str1, str2);
        System.out.println(result);
    }
}
