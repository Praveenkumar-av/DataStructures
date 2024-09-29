// Knapsack problem in java using recursion

class KnapSack {
    static int maxCapacity(int w, int[] wt, int[] val, int ind) {
        if (ind == 0) {
            if (wt[0] <= w) {
                return val[0]; 
            }else {
                return 0;
            }
        }

        int pick = 0;
        if (w >= wt[ind]) {
            pick = val[ind] + maxCapacity(w - wt[ind], wt, val, ind - 1);
        }

        int notpick = maxCapacity(w, wt, val, ind - 1);

        return Math.max(pick, notpick);
    }

    static int knapSack(int W, int wt[], int val[]) {
        int n = val.length;
        return maxCapacity(W, wt, val, n - 1);
    }

    public static void main(String[] args){
        int[] val = {1, 2, 3};
        int[] wt = {4,5,1};
        int W = 4;
        
        int result = knapSack(W, wt, val);
        System.out.println(result);
    }
}