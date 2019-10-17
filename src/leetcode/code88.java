package leetcode;

import java.util.Arrays;

public class code88 {
    //执行0ms
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = Arrays.copyOf(nums1, m + n);
        int i = 0, j = 0, index = 0;
        while (index < m + n) {
            if (j < n) {
                if (nums1Copy[i] > nums2[j]) {
                    nums1[index++] = nums2[j++];
                } else if (i < m) {
                    nums1[index++] = nums1Copy[i++];
                } else {
                    nums1[index++] = nums2[j++];
                }
            } else {
                nums1[index++] = nums1Copy[i++];
            }
        }
    }
    //执行 2ms
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            boolean inserted = false;
            for (int j = 0; j < m; j++) {
                if (nums2[i] <= nums1[j]) {
                    System.arraycopy(nums1, j, nums1, j + 1, m++ - j);
                    nums1[j] = nums2[i];
                    inserted=true;
                    break;
                }

            }
            if (!inserted) {
                nums1[m++] = nums2[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {};
        new code88().merge(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1));
    }


}
