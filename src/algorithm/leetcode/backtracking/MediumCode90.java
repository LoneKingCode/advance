package algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangzixiang
 * @date 2021/6/14
 */
public class MediumCode90 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        f(nums, new ArrayList<>(), 0);
        return result;
    }

    public void f(int[] nums, List<Integer> temp, int start) {
        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            f(nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new MediumCode90().subsetsWithDup(new int[]{1, 2, 2}));
    }
}
