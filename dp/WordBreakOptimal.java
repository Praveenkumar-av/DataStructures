// wordbreak problem using Tabulation

import java.util.*;

class WordBreakOptimal {

    static int wordBreakTab(int n, String s, ArrayList<String> dictionary) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];

        dp[0][0] = 1;

        for (int ind = 1; ind <= len; ind++) {
            // copy the previous values

            for (int i = 0; i <= len; i++) {
                dp[ind][i] = dp[ind - 1][i];
            }

            for (int i = ind; i > 0; i--) {
                if (dp[ind][i - 1] > 0 && dictionary.contains(s.substring(i - 1, ind))) {
                    dp[ind][ind] = 1;
                }
            }
        }

        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= len; j++) {
                System.out.print(dp[i][j] + " ");
            }

            System.out.println();
        }

        return dp[len][len];
    }

    static int wordBreak(int n, String s, ArrayList<String> dictionary) {
        int len = s.length();
        int[] dp = new int[len + 1];

        dp[0] = 1;

        for (int ind = 1; ind <= len; ind++) {
            for (int i = ind; i > 0; i--) {
                if (dp[i - 1] > 0 && dictionary.contains(s.substring(i - 1, ind))) {
                    dp[ind] = 1;
                }
            }
        }

        return dp[len];
    }

    public static void main(String[] args) {
        // String s = "ilikesam";
        String s = "catsanddog";

        // ArrayList<String> dictionary = new ArrayList<>(List.of("i", "like", "sam", "sung", "samsung", "mobile"));
        ArrayList<String> dictionary = new ArrayList<>(List.of("cat", "cats", "and", "sand", "dog"));

        System.out.println(wordBreakTab(dictionary.size(), s, dictionary));
    }
}
