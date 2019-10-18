import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

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
        new Main().maxProfit(nums);

    }


}
