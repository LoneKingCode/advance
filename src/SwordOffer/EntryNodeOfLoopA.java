package SwordOffer;

/**
 * 题目：链表中环的入口结点
 * 描述:给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 思路：1.一个快指针，一个慢指针，首先同时出发，找到相遇点
 * 2.然后快指针从起点重新出发，慢指针从相遇点出发，再次相遇时，此点就是环入口
 */
public class EntryNodeOfLoopA {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        //1.快指针每次走两步 满指针一步
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //2.找到相遇点
            if (slow == fast) {
                break;
            }
        }
        //为null说明不存在环
        if (fast == null || fast.next == null) {
            return null;
        }
        //3.快指针从起点出发
        fast = pHead;
        //4.再次找到相遇点
        while (fast != slow) {
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
        node.next.next.next.next = node.next.next;
        new EntryNodeOfLoopA().EntryNodeOfLoop(node);
    }

}

