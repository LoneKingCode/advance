package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class code46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int n : nums) {
            numbers.add(n);
        }
        backtrack(0, res, numbers, new ArrayList<>());
        return res;
    }

    private void backtrack(int first, List<List<Integer>> res, ArrayList<Integer> numbers, ArrayList<Integer> temp) {
        //当都交换过的话
        if (first == numbers.size())
            res.add(new ArrayList<>(numbers));
        for (int i = first; i < numbers.size(); i++) {
            //依次交换顺序
            Collections.swap(numbers, first, i);
            backtrack(first + 1, res, numbers, temp);
            //恢复顺序
            Collections.swap(numbers, first, i);
        }
    }

    private void backtrack1(int start, List<List<Integer>> res, ArrayList<Integer> numbers) {
        if (start > numbers.size() - 1) {
            return;
        }
        ArrayList<Integer> temp = new ArrayList<>(numbers);
        //把该位置元素放到头部
        temp.add(0, temp.get(start));
        temp.remove(start + 1);
        res.add(new ArrayList<>(temp));
        int count = 0;
        //除去本位 两位两位交换值
        int i = 1;
        while (i < temp.size()) {
            if (count >= temp.size() - 1) {
                backtrack1(start + 1, res, numbers);
                break;
            } else {
                if (i + 1 < temp.size()) {
                    Integer swap = temp.get(i);
                    temp.set(i, temp.get(i + 1));
                    temp.set(i + 1, swap);
                    if (!res.contains(temp))
                        res.add(new ArrayList<>(temp));

                } else {
                    i = 0;
                    count++;
                }
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        System.out.println(new code46().permute(num));

    }
}
