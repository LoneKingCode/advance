package SwordOffer;

/**
 * 题目：二进制中1的个数
 * 描述：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 思路：
 * 1.每次将n与1进行与运算，判断最后一位是1的话，就计数+1，然后将该数无符号右移
 * 2.利用1，将1与n进行与运算，为1则计数+1，然后再将1左移,意思就是那一个1与n的各个位置进行比较
 * 3.利用n&(n-1),这个式子可以将二进制数字中的最后的一个1变为0，有几个1就运算几次，效率最高
 */
public class numberOf1 {
    //思路1
    public int NumberOf1_1(int n) {
        if (n == 0) {
            return 0;
        }
        int result = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                result++;
            }
            n = n >>> 1;
        }
        return result;
    }

    //思路2
    public int NumberOf1_2(int n) {
        if (n == 0) {
            return 0;
        }
        int result = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                result++;
            }
            flag = flag << 1;
        }
        return result;
    }

    //思路3
    public int NumberOf1_3(int n) {
        if (n == 0) {
            return 0;
        }
        int result = 0;
        while (n != 0) {
            n = n & (n - 1);
            result++;
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
    }
}

