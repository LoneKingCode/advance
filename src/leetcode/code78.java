package leetcode;

import java.util.ArrayList;
import java.util.List;

public class code78 {
    //回溯法
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);
            backtrack(j + 1, nums, res, temp);
            temp.remove(temp.size() - 1);
        }
    }

    //逐个枚举，空集的幂集只有空集，每增加一个元素，让之前幂集中的每个集合，追加这个元素，就是新增的子集。
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (Integer n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> before = new ArrayList<Integer>(res.get(i));
                before.add(n);
                res.add(before);
            }
        }
        return res;
    }

    //此法结果对，但是不符合leetcode的输出顺序
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ArrayList item = new ArrayList<Integer>();
            item.add(nums[i]);
            res.add(item);
            int a = 0;

            //完整的
            while (a < nums.length - i - 1) {
                item = new ArrayList<Integer>();
                for (int j = i; j < nums.length - a; j++) {
                    item.add(nums[j]);
                }
                a++;
                res.add(item);
            }
            if (nums.length - 1 > i + 1) {
                //跳着的
                item = new ArrayList<Integer>();
                for (int j = nums.length - 1; j > i + 1; j--) {
                    item.add(nums[i]);
                    item.add(nums[j]);
                }
                res.add(item);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        System.out.println(new code78().subsets(num));

    }
}
