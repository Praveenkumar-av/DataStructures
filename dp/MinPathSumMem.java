// Program to find the minimum Path sum in a grid using memoization 

import java.util.Arrays;
class MinPathSumMem {
    static int minPath(int[][] grid, int x, int y, int[][] dp){
        if(x == 0 && y == 0)
            return grid[x][y];

        if(dp[x][y] != -1)
            return dp[x][y];

        int top = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
        if(y-1 >= 0) left = minPath(grid, x, y-1, dp);
        if(x-1 >= 0) top = minPath(grid, x-1, y, dp);

        return dp[x][y] = grid[x][y] + Math.min(left, top);
    }

    static  int minPathSum(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int[][] dp = new int[r][c];
        for(int i=0; i<r; i++)
            Arrays.fill(dp[i], -1);

        return minPath(grid, r-1, c-1, dp);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        System.out.println(minPathSum(grid));
    }
}