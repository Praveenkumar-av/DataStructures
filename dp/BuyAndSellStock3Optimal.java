
class BuyAndSellStock3Optimal {

    static int maximumProfit(int[] prices) {
        int n = prices.length;

        int[][] front = new int[2][4];
        int[][] cur = new int[2][4];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int count = 0; count <= 2; count++) {
                    if (buy == 0) {
                        cur[buy][count] = Math.max(-prices[i] + front[1][count + 1], front[0][count]);
                    } else {
                        cur[buy][count] = Math.max(prices[i] + front[0][count], front[1][count]);
                    }
                }
            }
            front = cur.clone();
        }

        return front[0][0];
    }

    public static void main(String[] args) {
        int[] prices = {10, 22, 5, 75, 65, 80};
        // int[] prices = {2, 30, 15, 10, 8, 25, 80};

        System.out.println(maximumProfit(prices));
    }
}
