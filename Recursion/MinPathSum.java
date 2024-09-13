// Program to find the minimum Path sum in a grid using recursion 
class MinPathSum {
    static int minPath(int[][] grid, int x, int y){
        if(x == 0 && y == 0)
            return grid[x][y];

        int top = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
        if(y-1 >= 0) left = minPath(grid, x, y-1);
        if(x-1 >= 0) top = minPath(grid, x-1, y);

        return grid[x][y] + Math.min(left, top);
    }

    static int minPathSum(int[][] grid) {
        int r = grid.length, c = grid[0].length;

        return minPath(grid, r-1, c-1);
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