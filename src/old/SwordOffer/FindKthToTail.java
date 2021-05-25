package old.SwordOffer;

/**
 * 题目：链表中倒数第k个结点
 * 介绍：输入一个链表，输出该链表中倒数第k个结点。
 * 思路：一看就是快慢指针，快指针提前走K步，然后快慢指针开始同时走，
 * 当快指针走到尽头时，慢指针就是倒数第K个结点
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) return null;
        ListNode fast = head;
        ListNode slow = head;
        //注意 i为1，而不是0，因为fast当前位置就是head，也就是第一个结点
        for (int i = 1; i < k; i++) {
            //判断快指针能不能提前走K步
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        //开始同时走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        System.out.println(new FindKthToTail().FindKthToTail(node, 13));
    }

}

//class ListNode {
//    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}