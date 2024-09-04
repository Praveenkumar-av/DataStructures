class FibanocciTabulation{

    // function to find the n th fibanocci term using dp with tabulation
    static int fibanocci(int n){
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2; i<=n; i++){
            arr[i] = arr[i-1]+arr[i-2];
        }

        return arr[n];
        // time complexity : O(n)
        // space complexity : O(n)
    }

    // space optimization
    static int fibanocciOptimal(int n){
        int prev2 = 0;
        int prev1 = 1;

        for(int i=2; i<=n; i++){
            int next = prev1+prev2;
            prev2 = prev1;
            prev1 = next;
        }

        return prev1;
        // time complexity : O(n)
        // space complexity : O(1)
    }

    public static void main(String[] args){
        int n = 5;
        System.out.println("n th fibanocci term using tabulation :"+fibanocci(n));

        System.out.println("n th fibanocci term Optimal :"+fibanocciOptimal(n));
    }
}