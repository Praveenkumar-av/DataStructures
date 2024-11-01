// wordbreak problem using recursion
import java.util.*;

class WordBreak {

    static int f(String s, int ind, ArrayList<String> dictionary) {
        if (ind < 0) {
            return 1;
        }

        for (int i = ind; i >= 0; i--) {
            if (dictionary.contains(s.substring(i, ind + 1))) {
                if (f(s, i - 1, dictionary) > 0) {
                    return 1;
                }
            }
        }

        return 0;
    }

    static int wordBreak(int n, String s, ArrayList<String> dictionary) {
        return f(s, s.length() - 1, dictionary);
    }

    public static void main(String[] args) {
        String s = "ilike";
        // String s = "baaabab";

        ArrayList<String> dictionary = new ArrayList<>(List.of("i", "like", "sam", "sung", "samsung", "mobile"));

        System.out.println(wordBreak(dictionary.size(), s, dictionary));
    }
}
