// Print Longest Common subsequence (All pattern) using Backtracking

import java.util.*;
class PrintAllLCS {

    static ArrayList<String> printLCS(int n, int m, String s1, String s2) {
        int[][] dp = new int[n + 1][m + 1];

        // generate the tabulation of lcs
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        for (int[] arr : dp) {
            for (int e : arr) {
                System.out.print(e + " ");
            }
            System.out.println();
        }

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(n, m, new StringBuilder()));
        TreeSet<String> result = new TreeSet<>();

        while(!q.isEmpty()){
            Node v = q.pollFirst();
            int x = v.x;
            int y = v.y;
            StringBuilder s = new StringBuilder(v.s);

            if(x > 0 && y > 0){
                if(s1.charAt(x-1) == s2.charAt(y-1)){
                    s.append(s1.charAt(x - 1));
                    q.offerLast(new Node(x-1, y-1, s));
                }
                else if(dp[x][y - 1] == dp[x - 1][y]){
                    q.offerLast(new Node(x, y-1, s));
                    q.offerLast(new Node(x-1, y, s));
                }
                else if(dp[x][y - 1] > dp[x - 1][y]){
                    q.offerLast(new Node(x, y-1, s));
                }
                else {
                    q.offerLast(new Node(x-1, y, s));
                }
            }
            else{
                result.add(s.reverse().toString());
            } 
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        // String s1 = "XYZW", s2 = "XYWZ";
        // String s1 = "abaaa";
        // String s2 = "baabaca";
        String s1 = "mbadm";
        String s2 = "mdabm";
        int n = s1.length();
        int m = s2.length();

        ArrayList<String> result = printLCS(n, m, s1, s2);
        System.out.println(result);
    }
}

class Node{
    int x, y;
    StringBuilder s;

    Node(int x, int y, StringBuilder s){
        this.x = x;
        this.y = y;
        this.s = s;
    }
}