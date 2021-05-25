package old.SwordOffer;

/**
 * 题目：复杂链表的复制
 * 描述: 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 思路： 同步复制， 复制一个节点 往后移动一下
 */
public class CloneRandomListNode {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        //先把头节点复制一下
        RandomListNode p = new RandomListNode(pHead.label);
        RandomListNode result = p;
        if (pHead.random != null) {
            p.random = new RandomListNode(pHead.random.label);
        }
        //继续往后复制
        while (pHead.next != null) {
            pHead = pHead.next;
            //复制next
            p.next = new RandomListNode(pHead.label);
            //复制random
            if (pHead.random != null) {
                p.next.random = new RandomListNode(pHead.random.label);
            }
            //往后走
            p = p.next;
        }
        return result;
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