import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public int[] twoSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(0, 0, nums, target, result, new ArrayList<>(), used);
        return result.get(0).stream().mapToInt(Integer::valueOf).toArray();
    }

    private void backtrack(int start, int cur, int[] nums, int target,
                           List<List<Integer>> result, List<Integer> temp, boolean[] used) {
        if (cur == target && !temp.isEmpty()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i])
                continue;
//            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
//                continue;
//            }
            cur += nums[i];
            used[i] = true;
            temp.add(i); //记录索引 不是值
            backtrack(start + 1, cur, nums, target, result, temp, used);
            cur -= nums[i];
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] num = {0, 4, 3, 0};
        System.out.println(Arrays.toString(new Main().twoSum(num, 0)));

    }
}
