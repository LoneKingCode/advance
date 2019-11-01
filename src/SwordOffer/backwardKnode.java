package SwordOffer;

public class backwardKnode {
    //倒数第K个结点
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) return null;
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 1; i < k; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        while (fast.next != null) {
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
        System.out.println(new backwardKnode().FindKthToTail(node, 13));
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