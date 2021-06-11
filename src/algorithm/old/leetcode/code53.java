package algorithm.old.leetcode;

public class code53 {
    //2ms
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int j = 1; j < nums.length; j++) {
            //1.我前一天赢钱了，今天继续 2.我前一天输了，我忘记我输了，不算
            dp[j] = dp[j - 1] >= 0 ? dp[j - 1] + nums[j] : nums[j];
            if (dp[j] > max) max = dp[j];
        }
        return max;
    }
 //63ms 暴力法
    public int maxSubArray1(int[] nums) {
        if (nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < nums.length; j++) {
            int temp = 0;
            for (int k = j; k < nums.length; k++) {
                temp += nums[k];
                if (temp > max) max = temp;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new code53().maxSubArray(arr));
    }
//    public boolean exist(char[][] board, String word) {
//
//    }
//
//    private void backtrack() {
//
//    }
//
//    public static void main(String[] args) {
//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
//        System.out.println(new Main().exist(board, "ABCCED"));
//        System.out.println(new Main().exist(board, "SEE"));
//        System.out.println(new Main().exist(board, "ABCB"));
//
//    }

}
