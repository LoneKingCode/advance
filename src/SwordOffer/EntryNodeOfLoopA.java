package SwordOffer;

public class EntryNodeOfLoopA {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null && pHead.next == null) return null;
        ListNode fast = pHead;
        ListNode slow = pHead;
        //先找到相遇点
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }
        if (fast == null || fast.next == null)
            return null;
        slow = pHead;
        //一个从头出发 一个从相遇点除法 一定会在入口相遇
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
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

