package algorithm.old.leetcode;

import java.util.Arrays;

public class code66 {
    public int[] plusOne(int[] digits) {
        //进位
        int carry = 0;
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1)
                sum = digits[i] + 1;
            else {
                sum = digits[i] + carry;
                carry=0;
            }
            if (sum > 9) {
                int _carry = sum / 10; //进位
                sum = sum % 10;
                digits[i] = sum;
                carry = _carry;
            } else {
                digits[i] = sum;
            }
        }
        if(carry!=0)
        {
            int[] result = new int[digits.length+1];
            result[0] = carry;
            System.arraycopy(digits,0,result,1,digits.length);
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] arr = {1,9,9};
        System.out.println(Arrays.toString(new code66().plusOne(arr)));
    }

}
