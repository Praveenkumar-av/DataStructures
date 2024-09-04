// program to find the n th finocci number 

import java.util.Arrays;
class FibanocciRecursion{
    // normal recursion
    static int count=0;
    static int fibanocci(int n){
        count++;
        if(n < 2)
            return n;
        
        return fibanocci(n-1)+fibanocci(n-2);
        // time complexity : O(n^2)
    }

    // recursion with memoization -> dp solution
    static int countdp = 0;
    static int fibanocciDp(int n, int[] dp){
        countdp++;
        if(n < 2)
            return n;
        if(dp[n] != -1)
            return dp[n];

        return dp[n] = fibanocciDp(n-1, dp) + fibanocciDp(n-2, dp);
        // time complexity : O(n)
    }

    public static void main(String []args){
        int n = 10;

        System.out.println("n th fibanocci using recursion :"+fibanocci(n));
        System.out.println("no. of times normal recursion run :"+FibanocciRecursion.count);

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println("n th fibanocci using dp :"+fibanocciDp(n, dp));
        System.out.println("no. of times recursion with memoization run :"+FibanocciRecursion.countdp);
    }
}