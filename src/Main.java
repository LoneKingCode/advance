import org.omg.CORBA.INTERNAL;
import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public int Add(int num1, int num2) {
        return num2 == 0 ? num1 : Add(num1 ^ num2, (num1 & num2) << 1);
    }

    public static void main(String[] args) {
        System.out.println(new Main().Add(5, 7));

    }

}

