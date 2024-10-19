// Edit distance problem using resursion
// Given two strings str1 and str2. Return the minimum number of operations required to convert str1 to str2.
// The possible operations are permitted:
//    1.Insert a character at any position of the string.
//    2.Remove any character from the string.
//    3.Replace any character from the string with any other character.

class EditDistance {
    static int f(String s1, String s2, int i, int j){
        if(i < 0)
            return j+1;
        if(j < 0)
            return i+1;

        if(s1.charAt(i) == s2.charAt(j))
            return f(s1, s2, i-1, j-1);  // if both the character matches

        int in = 1 + f(s1, s2, i, j-1);  // insert the character in s1
        int del = 1 + f(s1, s2, i-1, j); // delete
        int rep = 1 + f(s1, s2, i-1, j-1); // replace

        return Math.min(in, Math.min(del, rep));
    }

    static int editDistance(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        return f(s1, s2, n-1, m-1);
    }

    public static void main(String[] args){
        String s1 = "horse";
        String s2 = "ros";

        int result = editDistance(s1, s2);
        System.out.println(result);
    }
}