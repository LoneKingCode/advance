package old.leetcode;

public class code122 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > 0) {
                if (prices[i + 1] < prices[i]) {
                    profit += prices[i] - min;
                    min = prices[i + 1];
                    i = i + 1;
                } else {
                    continue;
                }
            } else {
                min = prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(new code122().maxProfit(arr));
    }


}
