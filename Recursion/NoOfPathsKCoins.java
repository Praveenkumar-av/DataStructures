// Given a n x n matrix such that each of its cells contains some coins. 
// Count the number of ways to collect exactly k coins while moving from 
// top left corner of the matrix to the bottom right. From a cell (i, j), 
// you can only move to (i+1, j) or (i, j+1).

// Recursion
class NoOfPathsKCoins {
    static int count = 0;
    static long countPath(int[][] arr, int n, int x, int y, int rem) {
        count++;
        // System.out.println(x + " " + y + " " + rem);
        if (x < 0 || y < 0) {
            return 0; 
        }else if (x == 0 && y == 0) {
            if (rem == arr[0][0]) {
                return 1; 
            }else {
                return 0;
            }
        }

        long top = countPath(arr, n, x - 1, y, rem - arr[x][y]);
        long left = countPath(arr, n, x, y - 1, rem - arr[x][y]);
        return top + left;
    }

    static long numberOfPath(int n, int k, int[][] arr) {
        long result = countPath(arr, n, n - 1, n - 1, k);

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3},
            {4, 6, 5},
            {3, 2, 1}
        };
        System.out.println(numberOfPath(arr.length, 12, arr));
        System.err.println(count);
    }
}
