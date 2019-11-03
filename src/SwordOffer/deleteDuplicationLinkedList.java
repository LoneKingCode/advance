package SwordOffer;

public class deleteDuplicationLinkedList {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return pHead;
        ListNode p1 = pHead;
        ListNode pre = null;
        while (p1 != null && p1.next != null) {
            //相同值的结点
            if (p1.val == p1.next.val) {
                ListNode p2 = p1.next;
                while (p2 != null) {
                    if (p1.val != p2.val)
                        break;
                    p2 = p2.next;
                }
                if (pre == null) {
                    pHead = p2;
                    pre = pHead;
                } else {
                    pre.next = p2;
                    if (pHead != null && pHead.val == p1.val) pHead = null;
                }
                p1 = p2;
                continue;
            }
            pre = p1;
            p1 = p1.next;
        }
        return pHead;
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(3);
        node.next.next.next.next.next = new ListNode(3);
//        node.next.next.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next.next.next = new ListNode(5);
        new deleteDuplicationLinkedList().deleteDuplication(node);
    }

}

