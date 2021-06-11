package algorithm.old.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int j = i; j < nums.length; j++) {
            //和上一个数字相同则跳过
            if (j > i && nums[j] == nums[j - 1])
                continue;
            temp.add(nums[j]);
            backtrack(j + 1, nums, res, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 2};
        System.out.println(new code90().subsetsWithDup(num));

    }
}
