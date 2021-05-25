package old.leetcode;

public class code121 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int min = prices[0];
        int profit = 0;
        for (int p : prices) {
            if (p - min > 0) {
                profit = Math.max(p - min, profit);
            } else {
                min = p;
            }
        }
        return profit;
    }


    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 6, 9};
        new code121().maxProfit(nums);

    }


}
