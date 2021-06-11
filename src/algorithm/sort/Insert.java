package algorithm.sort;

import java.util.Arrays;

/**
 * @Author : LoneKing
 * @Description: 插入排序
 * @Date: Created in 16:18 2020/3/12
 * @Modified By: LoneKing
 * @Blame: LoneKing
 */
public class Insert {
    public static void insertSort(int[] array) {
        for (int i = 1, j; i < array.length; i++) {
            int current = array[i];
            for (j = i - 1; j >= 0 && array[j] > current; j--) {
                //把大于current的数都往后移
                array[j + 1] = array[j];
            }
            array[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 4, 5, 7, 5, 4, 6, 7};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
