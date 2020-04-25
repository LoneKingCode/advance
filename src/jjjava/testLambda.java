package jjjava;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LoneKing
 */
public class testLambda {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.forEach(System.out::println);
        System.out.printf("\n");
        list.forEach(x -> System.out.print(x));
    }
}
