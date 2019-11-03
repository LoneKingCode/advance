import org.omg.CORBA.INTERNAL;
import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public RandomListNode Clone(RandomListNode pHead) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p1 = pHead;
        RandomListNode p2 = pHead;
        while (p1 != null) {
            map.put(p1, new RandomListNode(p1.label));
            p1 = p1.next;
        }
        while (p2 != null) {
            //复制的结点 指向 原结点指向的结点的复制节点
            map.get(p2).next = map.get(p2.next);
            //复制的结点 随机指向 原结点随机指向的结点的复制结点
            map.get(p2).random = map.get(p2.random);
            p2 = p2.next;
        }
        return map.get(pHead);
    }

    public static void main(String[] args) {

    }

}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}