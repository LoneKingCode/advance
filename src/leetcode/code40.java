package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, 0, res, new ArrayList<Integer>(), candidates, target);
        return res;
    }

    private void backtrack(int start, int cur, List<List<Integer>> res, List<Integer> temp, int[] candidates, int target) {
        if (cur == target) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = start; i < candidates.length; i++) {
            //重复的跳过， 还是candidates必须是已经排序后的，此处为升序
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (cur + candidates[i] <= target) {
                temp.add(candidates[i]);
                cur += candidates[i];
                backtrack(i + 1, cur, res, temp, candidates, target);
                cur -= candidates[i];
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] num = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(new code40().combinationSum2(num, 8));

    }
}
