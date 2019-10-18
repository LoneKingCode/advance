package leetcode;

import java.util.ArrayList;
import java.util.List;

public class code119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> last = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (i > 1 && (j > 0 && j <= i - 1)) {
                    int value = last.get(j - 1) + last.get(j);
                    temp.add(value);
                } else {
                    temp.add(1);
                }
            }
            last = temp;
        }
        return last;
    }


    public static void main(String[] args) {

        new code119().getRow(3);
    }


}
