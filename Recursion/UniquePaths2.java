// Program to find the number of unique paths in a grid with obstacles using recursion

import java.util.Arrays;
class UniquePaths2 {
    static int count = 0;

    static int dfs(int[][] grid, int x, int y){
        count++;
        int r = grid.length, c = grid[0].length;
        if(x >= r || y >= c || grid[x][y]==1)
            return 0;
        else if(x == r-1 && y == c-1)
            return 1;

        return dfs(grid, x, y+1) + dfs(grid, x+1, y);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        return dfs(obstacleGrid, 0, 0);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };
        System.out.println(uniquePathsWithObstacles(grid));
        System.out.println("no. of steps :"+count);
    }
} 