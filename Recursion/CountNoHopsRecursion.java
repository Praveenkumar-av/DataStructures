// program to count the no. of possible ways to reach the n th step if 1, 2, and 3 jumps are used

import java.util.Arrays;

class CountNoHopsRecursion{
    static int count=0;
    static int find(int rem){
        count++;
        if(rem == 0)
            return 1;
        else if(rem < 0)
            return 0;
        
        return find(rem-1)+find(rem-2)+find(rem-3);
    }

    // with memoization
    static int hops(int n, int[] mem){
        count++;
        if(n < 0)
            return 0;
        else if(n == 0)
            return 1;
        
        if(mem[n] != -1)
            return mem[n];
        
        return mem[n] = hops(n-1, mem) + hops(n-2, mem) + hops(n-3, mem);
    }

    public static void main(String[] args){
        int n = 10;
        
        System.out.println("No of ways with recursion :"+find(n));
        System.out.println("count of recursion :"+CountNoHopsRecursion.count);

        int[] mem = new int[n+1];
        Arrays.fill(mem, -1);
        CountNoHopsRecursion.count=0;
        System.out.println("No of ways with recursion with memoization:"+hops(n, mem));
        System.out.println("count of recursion with memoization :"+CountNoHopsRecursion.count);
    }
}