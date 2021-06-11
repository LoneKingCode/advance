package algorithm.sort;

import java.util.Arrays;

/**
 * @Author : LoneKing
 * @Description: 冒泡排序 时间复杂度最优O(n^2)最差O(n^2)
 * @Date: Created in 16:05 2020/3/12
 * @Modified By: LoneKing
 * @Blame: LoneKing
 */
public class Bubble {
    public static void bubbleSort(int[] array) {
        boolean hasChange = true;
        for (int i = 0; i < array.length - 1 && hasChange; i++) {
            hasChange = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
//                    array[j] += array[j + 1];
//                    array[j + 1] = array[j] - array[j + 1];
//                    array[j] -= array[j + 1];
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    hasChange = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 4, 5, 7, 5, 4, 6, 7};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
