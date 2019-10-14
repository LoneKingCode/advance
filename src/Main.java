import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        Arrays.sort(nums);
        for (int n : nums) {
            numbers.add(n);
        }
        backtrack(0, res, numbers, new ArrayList<>());
        return res;
    }

    private void backtrack(int first, List<List<Integer>> res, ArrayList<Integer> numbers, ArrayList<Integer> temp) {
        if (first == numbers.size())
            res.add(new ArrayList<>(numbers));
        for (int i = first; i < numbers.size(); i++) {
            Collections.swap(numbers, first, i);
            backtrack(first + 1, res, numbers, temp);
            Collections.swap(numbers, first, i);
        }
    }


    public static void main(String[] args) {
        int[] num = {0,1,0,0,9};
        System.out.println(new Main().permuteUnique(num));

    }
}
