package SwordOffer;

import java.util.ArrayList;

public class cutRopeA {
    private int max = 0;
    public int cutRope(int target) {
        //最多剪target段
        for (int i = 2; i <= target; i++) {
            tryCut(0, new ArrayList<Integer>(), i, target);
        }
        return max;
    }

    public void tryCut(int cutCount, ArrayList<Integer> temp, int allowCut, int remain) {
        if (remain == 0) {
            int multiply = 1;
            for (Integer n : temp) {
                multiply *= n;
            }
            max = multiply > max ? multiply : max;
        }
        for (int i = 1; i <= remain; i++) {
                                        //防止一下分完不给后面留了
            if (allowCut > cutCount && (allowCut - cutCount - 1 <= remain - i)) {
                temp.add(i);
                tryCut(cutCount + 1, temp, allowCut, remain - i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new cutRopeA().cutRope(8));
    }

}

