package algorithm.old.leetcode;

import java.util.HashMap;

public class code189 {

    public int majorityElement(int[] nums) {
        if(nums.length==1) return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i])+1);
            }
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 3 };
        System.out.println(new code189().majorityElement(arr));
    }

}
