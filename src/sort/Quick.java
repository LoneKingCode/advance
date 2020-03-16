package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author : LoneKing
 * @Description:
 * @Date: Created in 20:25 2020/3/12
 * @Modified By: LoneKing
 * @Blame: LoneKing
 */
public class Quick {
    public static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int p = partition(array, low, high);
        quickSort(array, low, p - 1);
        quickSort(array, p + 1, high);
    }


    public static int partition(int[] array, int low, int high) {
        swap(array, randRange(low, high), high);
        int i, j;
        for (i = low, j = low; j < high; j++) {
            if (array[j] <= array[high]) {
                swap(array, i++, j);
            }
        }
        swap(array, i, j);
        return i;
    }

    public static int randRange(int start, int end) {
        return new Random().nextInt(end - start + 1) + start;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{9,8,5,7,6,1,4,3,2};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }
}
