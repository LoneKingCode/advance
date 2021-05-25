package old.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code47 {
    private boolean[] used;
    private List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        //记录位置信息 是否被使用
        used = new boolean[nums.length];

        backtrack(0, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(int depth, ArrayList<Integer> numbers, int[] nums) {
        if (depth == nums.length)
            res.add(new ArrayList<>(numbers));
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                numbers.add(nums[i]);
                used[i] = true;
                backtrack(depth + 1, numbers, nums);
                numbers.remove(numbers.size() - 1);
                used[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        System.out.println(new code47().permuteUnique(num));

    }
}
