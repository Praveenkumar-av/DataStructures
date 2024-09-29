// Find the maximum sum of a any possible subsequence such that no two numbers in the subsequence 
// should be adjacent in Arr.

class HouseRobberOptimal {
    static int findMaxSum(int arr[], int n) {
        if (n == 1) {
            return arr[0];
        }

        int prev = arr[0], prev2 = 0;

        for (int i = 1; i < n; i++) {
            int max = Math.max(arr[i] + prev2, prev);
            prev2 = prev;
            prev = max;
        }

        return prev;
    }
    public static void main(String[] args) {
        int[] arr = {5, 5, 10, 100, 10, 5};
        int n = arr.length;
        System.out.println(findMaxSum(arr, n));
    }
}