package algorithm.old.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code950 {
    public int[] deckRevealedIncreasing1(int[] deck) {
        List<Integer> list = new ArrayList<Integer>();
        //将元素从小到大排列
        Arrays.sort(deck);
        for (int i = deck.length - 1; i >= 0; i--) {
            if (list.size() >= 2) {
                //整体右移一位
                list.add(0, 0);
                //把末尾元素放到头
                list.set(0, list.get(list.size() - 1));
                list.remove(list.size() - 1);
            }
            list.add(0, deck[i]);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    //思路：将数据从小到大排序,逆序遍历数据，每次添加元素到结果数组头，然后将结果数组末尾元素再移到头部
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] result = new int[deck.length];
        int elementCount = 0;
        //将元素从小到大排列
        Arrays.sort(deck);
        for (int i = deck.length - 1; i >= 0; i--) {
            //整体右移一位
            System.arraycopy(result, 0, result, 1, elementCount);
            if (elementCount >= 2) {
                result[0] = result[elementCount];
            }
            //整体右移一位
            System.arraycopy(result, 0, result, 1, elementCount);
            result[0] = deck[i];
            elementCount++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 13, 3, 11, 5, 17, 7};
        System.out.println(Arrays.toString(new code950().deckRevealedIncreasing(arr)));

    }
}
