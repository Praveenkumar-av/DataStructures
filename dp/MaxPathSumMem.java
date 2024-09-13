// Program to find the maximum sum in a n*n matrix if the possible moves are 
// mat[r+1] [c]
// mat[r+1] [c-1]
// mat [r+1] [c+1]

import java.util.Arrays;
class MaxPathSumMem{
    static int maxPathSum(int[][] mat, int n, int x, int y, int[][] dp) {
        if (x == 0) {
            return mat[x][y];
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        int top, topleft, topright;
        top = topleft = topright = Integer.MIN_VALUE;

        top = maxPathSum(mat, n, x - 1, y, dp);
        if (y - 1 >= 0) {
            topleft = maxPathSum(mat, n, x - 1, y - 1, dp);
        }
        if (y + 1 < n) {
            topright = maxPathSum(mat, n, x - 1, y + 1, dp);
        }

        return dp[x][y] = mat[x][y] + Math.max(top, Math.max(topleft, topright));
    }

    static int maximumPath(int N, int Matrix[][]) {
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, maxPathSum(Matrix, N, N - 1, i, dp));
        }

        return result;
    }

    public static void main(String []args){
        int[][] mat = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        System.out.println(maximumPath(mat.length, mat));
    }
}