import java.util.Arrays;
class MaxPathSumOptimal{
    static int maximumPath(int N, int Matrix[][]) {
        int[] prev = Arrays.copyOf(Matrix[0], N);

        for (int i = 1; i < N; i++) {
            int[] temp = new int[N];
            for (int j = 0; j < N; j++) {
                int max = prev[j];
                if (j - 1 >= 0) {
                    max = Math.max(max, prev[j - 1]);
                }
                if (j + 1 < N) {
                    max = Math.max(max, prev[j + 1]);
                }

                temp[j] = max + Matrix[i][j];
            }
            prev = temp;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, prev[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        System.out.println(maximumPath(mat.length, mat));
    }
}