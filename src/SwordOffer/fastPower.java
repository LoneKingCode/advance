package SwordOffer;

/**
 * 题目：数值的整数次方
 * 介绍：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * 思路：
 * 1.普通算法，遍历乘exponent次，注意指数负数的话乘的是1/base
 * 2.快速幂算法
 * (1)当b为偶数时，a^b可以转为a^2的b/2次方。
 * (2)当b为奇数时，a^b可以转为a^2的b/2次方，再乘以a。
 */
public class fastPower {
    public double Power(double base, int exponent) {
        double result = 1;
        while (exponent != 0) {
            if (exponent > 0) {
                result *= base;
                exponent--;
            } else if (exponent < 0) {
                result *= (1 / base);
                exponent++;
            }
        }
        return result;
    }

    public double FastPower(double base, int exponent) {
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
        int n = 5, pow = 3;
        int result = 1;
        while (pow != 0) {
            if (pow % 2 == 1) {
                result = result * n % 1000;
            }

            pow /= 2;
            pow = (pow * pow) % 1000;
        }

        System.out.println(new fastPower().Power(2, -3));
    }

}

