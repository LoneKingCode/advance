package old.leetcode;


public class code50 {

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        double result = 1;
        while (n != 0) {
            //指数是正数，且是奇数
            if (n % 2 == 1) {
                result *= x;
            }
            //指数是负数，且是奇数
            else if (n % 2 == -1) {
                result *= (1 / x);
            }
            n /= 2;
            x *= x;
        }
        return  result;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new code50().myPow(2, -2));
    }
}

