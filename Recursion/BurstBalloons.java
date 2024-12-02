// Burst Ballon problem using recursion

import java.util.*;

class BurstBalloons {
    static int f(ArrayList<Integer> arl, int i, int j) {
        if(i > j)
            return 0;

        int max = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++)
        {
            int cost = arl.get(k) *arl.get(i-1) * arl.get(j+1)
                    + f(arl, i, k-1)
                    +  f(arl, k+1, j);

            max = Math.max(max, cost);
        }

        return max;
    }

    static int maxCoins(int[] nums) {
        ArrayList<Integer> arl = new ArrayList<>();
        int n = nums.length;

        for(int num : nums)
            arl.add(num);
        arl.addFirst(1);
        arl.add(1);

        return f(arl, 1, n);
    }

    public static void main(String[] args)
    {
        int[] nums = {3, 1, 5, 8};

        System.out.println(maxCoins(nums));
    }
}