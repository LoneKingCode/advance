package SwordOffer;

/**
 * 题目：合并两个排序的链表
 * 描述：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 思路：
 * 1.非递归：同时遍历两个链表，每次都比较下它们俩结点值，哪个链表结点用过了就让他往后走一步
 * 2.递归：比较list1和list2，谁小就递归调用该链表的.next继续执行
 * 递归的感觉就是在栈里，把list1和list2的结点全部拆赋值给局部变量p，按序排好了
 * 最后递归结束，p被从栈里依次弹出
 * 比如： 递归执行到最后一步时，这时候栈里充满了p
 * 栈顶
 * 7
 * 4
 * 3    递归结束=> 栈顶依次弹出 p=7  p=4->7 p=3->4->7 p = 3->3->4->7 p=2->3->3->4->7
 * 3
 * 2
 * 栈底
 */
public class mergeLinkedList {
    //递归版
    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode p = null;
        if (list1.val < list2.val) {
            p = list1;
            p.next = Merge1(list1.next, list2);
        } else {
            p = list2;
            p.next = Merge1(list1, list2.next);
        }
        return p;
    }

    //非递归
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode p = null;
        //这一步是为了给p搞个头结点，因为下面的while里直接用的next来拼接
        if (list1.val < list2.val) {
            p = list1;
            list1 = list1.next;
        } else {
            p = list2;
            list2 = list2.next;
        }
        ListNode result = p;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                //谁小拼谁
                if (list1.val < list2.val) {
                    p.next = list1;
                    list1 = list1.next;
                } else {
                    p.next = list2;
                    list2 = list2.next;
                }
            }
            //list1为null就只管把list2拼上就行
            else if (list1 == null) {
                p.next = list2;
                list2 = list2.next;
            }
            //只管拼list1
            else {
                p.next = list1;
                list1 = list1.next;
            }
            p = p.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(5);
        node1.next.next = new ListNode(7);
        node1.next.next.next = new ListNode(3);
        System.out.println(new mergeLinkedList().Merge(node, node1));
    }

}

