// wordbreak problem using memoization
import java.util.*;

class WordBreakMem {

    static int f(String s, int ind, ArrayList<String> dictionary, int[] dp) {
        if (ind < 0) {
            return 1;
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }

        for (int i = ind; i >= 0; i--) {
            if (dictionary.contains(s.substring(i, ind + 1))) {
                if (f(s, i - 1, dictionary, dp) > 0) {
                    return dp[ind] = 1;
                }
            }
        }

        return dp[ind] = 0;
    }

    static int wordBreak(int n, String s, ArrayList<String> dictionary) {
        int len = s.length();
        int[] dp = new int[n];
        for (int i = 0; i < len; i++) {
            dp[i] = -1;
        }

        return f(s, len-1, dictionary, dp);
    }

    public static void main(String[] args) {
        String s = "ilike";
        // String s = "baaabab";

        ArrayList<String> dictionary = new ArrayList<>(List.of("i", "like", "sam", "sung", "samsung", "mobile"));

        System.out.println(wordBreak(dictionary.size(), s, dictionary));
    }
}
