package algorithm.sort;

import java.util.Arrays;

/**
 * @Author : LoneKing
 * @Description:
 * @Date: Created in 19:20 2020/3/12
 * @Modified By: LoneKing
 * @Blame: LoneKing
 */
public class Merge {
    public static void mergeSort(int[] array, int low, int high) {
        //分完了
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        //不断的分
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        //合并子数组
        merge(array, low, mid, high);
    }

    public static void merge(int[] array, int low, int mid, int high) {
        int[] copy = array.clone();
        // 源数组索引  左数组索引   右数组索引
        int i = low, left = low, right = mid + 1;
        while (i <= high) {
            //左边已经分完了，直接分右边就行
            if (left > mid) {
                array[i++] = copy[right++];
            }
            //右边已经分完了，直接分左边就行
            else if (right > high) {
                array[i++] = copy[left++];
            } else if (copy[left] < copy[right]) {
                array[i++] = copy[left++];
            } else {
                array[i++] = copy[right++];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 9, 4, 5, 6, 8, 7, 0};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
