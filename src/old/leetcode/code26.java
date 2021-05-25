package old.leetcode;

import java.util.Arrays;

public class code26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int p = 0;
        for (int q = 1; q < nums.length; q++) {
            if (nums[p] != nums[q]) {
                nums[++p] = nums[q];
            }

        }
        System.out.println(Arrays.toString(nums));
        return p+1;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3,3,3};
        System.out.println(new code26().removeDuplicates(nums));
    }


}
