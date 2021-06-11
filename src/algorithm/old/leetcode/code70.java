package algorithm.old.leetcode;

public class code70 {


    //每一个台阶的解都是前两个的和
    public int climbStairs(int n) {
        if(n<3)
            return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2]=2;
        for(int i = 3; i <=n;i++)
        {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }



    public static void main(String[] args) {
        System.out.println(new code70().climbStairs(4));
    }


}
