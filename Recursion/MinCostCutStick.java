// Minimum cost to cut a stick using recursion

import java.util.*;
public class MinCostCutStick {

    static int f(int[] cuts, int i, int j) {
        if(i > j)
            return 0;

        int minCost = Integer.MAX_VALUE;
        for(int k=i; k<=j; k++) {
            int cost = (cuts[j+1] - cuts[i-1])
                    + f(cuts, i, k-1)
                    + f(cuts, k+1, j);
            
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

    static int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] cutsUpdated = new int[m+2];

        // add 0(at first) and n(to last) to the cutsUpdated array
        cutsUpdated[0] = 0;
        for(int i=0; i<m;i++)
            cutsUpdated[i+1] = cuts[i];
        cutsUpdated[m+1] = n;

        // Sort the array
        Arrays.sort(cutsUpdated);

        return f(cutsUpdated, 1, m);
    }
    public static void main(String[] args) {
        int[] cuts = {5, 4, 1, 3};
        int n = 7;

        System.out.println(minCost(n, cuts));
    }
}
