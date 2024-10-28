// wildcard pattern matching using recursion

class WildCard {

    static boolean f(String s1, String s2, int i, int j) {
        if (i == -1 && j == -1) {
            return true;
        }
        if (i < 0 || j < 0) {
            return false;
        }

        if (s1.charAt(i) == '?' || s1.charAt(i) == s2.charAt(j)) {
            return f(s1, s2, i - 1, j - 1);
        }

        if (s1.charAt(i) == '*') {
            return f(s1, s2, i - 1, j) || f(s1, s2, i, j - 1);
        }

        return false;
    }

    static boolean wildCard(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        return f(s1, s2, n - 1, m - 1);
    }

    public static void main(String[] args) {
        String s1 = "ba*a?";
        String s2 = "baaabab";

        System.out.println(wildCard(s1, s2));
    }
}
