package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class code1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub)) {
                return new int[]{map.get(sub),i};
            } else
                map.put(nums[i], i);
        }

        return new int[2];
    }



    public static void main(String[] args) {
        int[] num = {0, 4, 3, 0};
        System.out.println(Arrays.toString(new code1().twoSum(num, 0)));

    }
}
