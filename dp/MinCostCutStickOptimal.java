// Minimum cost to cut a stick using dp(tabulation)

import java.util.*;

public class MinCostCutStickOptimal {

    static int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] cutsUpdated = new int[m + 2];

        // add 0(at first) and n(to last) to the cutsUpdated array
        cutsUpdated[0] = 0;
        System.arraycopy(cuts, 0, cutsUpdated, 1, m);
        cutsUpdated[m + 1] = n;

        // Sort the array
        Arrays.sort(cutsUpdated);

        // dp array for memoization
        int[][] dp = new int[m + 2][m + 2];

        for (int i = m; i >= 1; i--) {
            for (int j = i; j <= m; j++) {
                int minCost = Integer.MAX_VALUE;

                for (int k = i; k <= j; k++) {
                    int cost = (cutsUpdated[j + 1] - cutsUpdated[i - 1])
                            + dp[i][k - 1]
                            + dp[k + 1][j];

                    minCost = Math.min(minCost, cost);
                }

                dp[i][j] = minCost;
            }
        }

        return dp[1][m];
    }

    public static void main(String[] args) {
        int[] cuts = {5, 4, 1, 3};
        int n = 7;

        System.out.println(minCost(n, cuts));
    }
}
