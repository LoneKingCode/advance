package algorithm.old.SwordOffer;

import java.util.Arrays;

/**
 * 题目：调整数组顺序使奇数位于偶数前面
 * 描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 思路：
 * 遍历数组，遇到偶数就放到末尾，注意循环的终止条件，要带上移动的次数
 */
public class reOrderArrayMain {
    public void reOrderArray(int[] array) {
        int move = 0;
        int index = 0;
        while (move + index < array.length) {
            if (array[index] % 2 == 0) {
                move++;
                int temp = array[index];
                //将该偶数之后所有元素左移一位，这样的话最后一个元素位置就空出来，用于放这个偶数
                System.arraycopy(array, index + 1, array, index, array.length - index - 1);
                //把该偶数放到最后一位
                array[array.length - 1] = temp;
                //因为整体左移了1位，所以index要-1
                index--;
            }
            index++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 9, 11, 13};
        new reOrderArrayMain().reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }

}

