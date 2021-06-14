package algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : LoneKing
 * @Date : 2021/6/5
 */
public class MediumCode78 {
    List<List<Integer>> result = new ArrayList<>();

//    public List<List<Integer>> subsets2(int[] nums) {
//        result.add(new ArrayList<>());
//        List<Integer> temp = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            temp.add(nums[i]);
//            result.add(new ArrayList<>(temp));
//            result.add(Arrays.asList(nums[i]));
//        }
//
//        return result;
//    }


    public List<List<Integer>> subsets(int[] nums) {
        f(nums, new ArrayList<>(), 0);
        return result;
    }

    public void f(int[] nums, List<Integer> temp, int start) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            f(nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new MediumCode78().subsets(nums));
        System.out.println(System.nanoTime() - start);
    }
}
