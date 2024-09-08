class UniquePaths2Optimal{
    static int uniquePathsWithObstacles(int[][] grid){
        int r = grid.length, c = grid[0].length;
        // array to store the top value
        int[] top = new int[c];

        // initialize the first row as 0 if the grid is 1 else 0
        top[0] = (grid[0][0]==1) ? 0 : 1;
        for(int j=1; j<c; j++)
            top[j] = (grid[0][j]==1) ? 0 : top[j-1];
        
        for(int i=1; i<r; i++){
            int[] left = new int[c];
            // initilize the left value as 0 if grid is 1 else top value
            left[0] = (grid[i][0] == 1) ? 0 : top[0];

            // calculate the rest of the elements
            for(int j=1; j<c; j++){
                if(grid[i][j] == 1)
                    left[j] = 0;
                else 
                    left[j] = top[j] + left[j-1];
            }
            // copy the left to top
            top = left;
        }

        return top[c-1];
    }

    public static void main(String[] args){
        int[][] grid = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        System.out.println(uniquePathsWithObstacles(grid));
    }
}