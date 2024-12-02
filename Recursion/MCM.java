// Matrix chain Multiplication problem using recursion

class MCM {

    static int f(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }

        int minSteps = (int) 1e9;
        for (int k = i; k <= j - 1; k++) {
            int steps = f(arr, i, k) // cost of left partition 
                    + f(arr, k + 1, j) // cost of right partition
                    + (arr[i - 1] * arr[k] * arr[j]);  // cost of mulitiplying left and right partition
            minSteps = Math.min(minSteps, steps);
        }

        return minSteps;
    }

    static int mcm(int[] arr) {
        int n = arr.length;
        return f(arr, 1, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("minimum no. of steps :" + mcm(arr));
    }
}
