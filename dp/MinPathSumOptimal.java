
class MinPathSumOptimal {

    static int minPathSum(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int[] prev = new int[c];
        // fill the first row
        prev[0] = grid[0][0];
        for(int i=1; i<c; i++)
            prev[i] = prev[i-1]+grid[0][i];

        for(int i=1; i<r; i++){
            int[] temp = new int[c];
            temp[0] = grid[i][0] + prev[0];
            for(int j=1; j<c; j++){
                temp[j] = grid[i][j] + Math.min(temp[j-1], prev[j]);
            }
            prev = temp;
        }

        return prev[c-1];
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
