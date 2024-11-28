// Program to find the longest increasing subsequence using recursion

class LIS { 
    static int f(int[] arr, int ind, int prev_ind) {
        if(ind < 0)
            return 0;

        int take = Integer.MIN_VALUE;
        if(prev_ind == -1 || arr[ind] < arr[prev_ind]) {
            take = 1 + f(arr, ind-1, ind);
        }
        int notTake = f(arr, ind-1, prev_ind);

        return Math.max(take, notTake);
    }

    static int lis(int[] arr) {
        int n = arr.length;
        
        return f(arr, n-1, -1);
    }

    public static void main(String[] args){
        int[] arr = {2, 1, 5, 4, 12}; 
        // int[] arr = {10, 9, 2, 5, 3, 7, 101, 18}; 

        System.out.println(lis(arr));
    }
}