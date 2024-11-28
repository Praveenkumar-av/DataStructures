// wordbreak2 problem using Tabulation and Backtracking

import java.util.*;

class WordBreak2 {

    static List<String> wordBreak(int n, String s, ArrayList<String> dictionary) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];

        dp[0][0] = 1;

        ArrayList<ArrayList<String>> matchedStrings = new ArrayList<>();
        for (int i = 0; i <= len; i++) {
            matchedStrings.add(new ArrayList<>());
        }

        matchedStrings.get(0).add("");

        for (int ind = 1; ind <= len; ind++) {
            // copy the previous values

            for (int i = 0; i <= len; i++) {
                dp[ind][i] = dp[ind - 1][i];
            }

            for (int i = ind; i > 0; i--) {
                if (dp[ind][i - 1] > 0 && dictionary.contains(s.substring(i - 1, ind))) {
                    dp[ind][ind] = 1;

                    // add the string that matched till ind to result
                    for (String str : matchedStrings.get(i - 1)) {
                        matchedStrings.get(ind).add(str + " " + s.substring(i - 1, ind));
                    }
                }
            }
        }

        // get the last matched string and add it to result
        ArrayList<String> result = new ArrayList<>();
        for (String str : matchedStrings.get(len)) {
            result.add(str.trim());
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "catsanddog";

        ArrayList<String> dictionary = new ArrayList<>(List.of("cat", "cats", "and", "sand", "dog"));

        System.out.println(wordBreak(dictionary.size(), s, dictionary));
    }
}
