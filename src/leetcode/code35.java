package leetcode;

public class code35 {
    public int searchInsert(int[] nums, int target) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (target >nums[i]) {
                return i+1;
            }
            if (nums[i] == target)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        System.out.println(new code35().searchInsert(arr, 5));
    }

}
