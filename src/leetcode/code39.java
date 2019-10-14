package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, 0, res, new ArrayList<Integer>(), candidates, target);
        return res;
    }

    private void backtrack(int start, int cur, List<List<Integer>> res, List<Integer> temp, int[] candidates, int target) {
        if (cur == target) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (cur + candidates[i] <= target) {
                    temp.add(candidates[i]);
                    cur += candidates[i];
                    //从当前位置再来一轮搜索
                    backtrack(i, cur, res, temp, candidates, target);
                    //每一次尝试以后要状态重置，代码与 backtrack 之前是对称的，列表最后添加了元素就要删除，累计和加上了就得减去
                    cur -= candidates[i];
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 6, 7};
        System.out.println(new code39().combinationSum(num, 7));

    }
}
