package algorithm.old.leetcode;

import java.util.ArrayList;
import java.util.List;

public class code118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (i > 1 && (j > 0 && j <= i-1 )) {
                    int value = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    temp.add(value);
                } else {
                    temp.add(1);
                }
            }
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {

        new code118().generate(5);
    }


}
