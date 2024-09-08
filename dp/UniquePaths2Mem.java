// Program to find the number of unique paths in a grid with obstacles using recursion with memoization

import java.util.Arrays;
class UniquePaths2Mem {
    static int count = 0;

    static int dfs(int[][] grid, int x, int y, int[][] dp){
        count++;
        int r = grid.length, c = grid[0].length;
        if(x >= r || y >= c || grid[x][y]==1)
            return 0;
        else if(x == r-1 && y == c-1)
            return 1;

        if(dp[x][y] != -1)
            return dp[x][y];

        return dp[x][y] = dfs(grid, x, y+1, dp) + dfs(grid, x+1, y, dp);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // create array for memoization
        int r = obstacleGrid.length, c = obstacleGrid[0].length;
        int[][] dp = new int[r][c];
        for(int i=0; i<obstacleGrid.length; i++)
            Arrays.fill(dp[i], -1);

        return dfs(obstacleGrid, 0, 0, dp);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        System.out.println(uniquePathsWithObstacles(grid));
        System.out.println("no. of steps :"+count);
    }
} 