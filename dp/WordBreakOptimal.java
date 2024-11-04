// wordbreak problem using Tabulation
import java.util.*;

class WordBreakOptimal {

    static int wordBreakTab(int n, String s, ArrayList<String> dictionary) {
        int len = s.length();
        int[][] dp = new int[n][len+1];

        dp[0][0] = 1;
        
        for(int ind=1; ind<=len; ind++) {
            for (int i = ind; i > 0; i--) {
                if (dp[ind][i-1] > 0 && dictionary.contains(s.substring(i-1, ind))) 
                        dp[ind][i] = 1;
            }
        }
                
        return dp[n][len];
    }

    static int wordBreak(int n, String s, ArrayList<String> dictionary) {
        int len = s.length();
        int[] dp = new int[len+1];

        dp[0] = 1;
        
        for(int ind=1; ind<=len; ind++)
            for (int i = ind; i > 0; i--) 
                if (dp[i-1] > 0 && dictionary.contains(s.substring(i-1, ind))) 
                        dp[ind] = 1;
                
        return dp[len];
    }

    public static void main(String[] args) {
        String s = "ilike";

        ArrayList<String> dictionary = new ArrayList<>(List.of("i", "like", "sam", "sung", "samsung", "mobile"));

        System.out.println(wordBreak(dictionary.size(), s, dictionary));
    }
}
