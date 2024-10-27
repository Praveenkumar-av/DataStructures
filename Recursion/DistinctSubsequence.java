// Distinct Subsequence using Recursion
// Given two strings txt and pat. Find the count of distinct occurrences of pat in txt as a 
// sub-sequence modulo 109 + 7.

class DistinctSubsequence {
    static int f(String s, String t, int i, int j){
        if(j < 0)
            return 1;
        if(i < 0)
            return 0;

        if(s.charAt(i) == t.charAt(j))
            return f(s, t, i-1, j-1) + f(s, t, i-1, j);

        return f(s, t, i-1, j);
    }

    static int subsequenceCount(String s, String t){
        int n = s.length();
        int m = t.length();

        return f(s, t, n-1, m-1);
    }

    public static void main(String[] args){
        String s = "banana";
        String t = "ban";

        System.out.println(subsequenceCount(s, t));
    }
}