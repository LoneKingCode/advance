package SwordOffer;

public class fastPower {
    //快速幂算法
    //3^10=(3*3)*(3*3)*(3*3)*(3*3)*(3*3)
    //3^10=(3*3)^5
    //3^10=9^5
    public double Power(double base, int exponent) {
        double result = 1;
        while (exponent != 0) {
            if (exponent % 2 == 1) {
                result *= base;
            } else if (exponent % 2 == -1) {
                result *= (1 / base);
            }
            exponent = exponent / 2;
            base = base * base;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(new fastPower().Power(2, -3));
    }

}

