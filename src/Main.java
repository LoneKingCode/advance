import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private int count = 0;

    public int JumpFloor(int target) {
        if (target == 0) {
            count++;
            return 0;
        }
        for (int i = 1; i <= 2; i++) {
            if (target - i >= 0) {
                JumpFloor(target - i);
            }
        }
        return count;
    }



    public static void main(String[] args) {
        new Main().
      System.out.println(  new Main().JumpFloor(2));
    }

}

