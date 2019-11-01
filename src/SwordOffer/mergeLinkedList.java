package SwordOffer;

public class mergeLinkedList {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1==null && list2==null) return null;
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode p3 = new ListNode(-1);
        ListNode result = p3;
        while (p1 != null || p2 != null) {
            if (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    p3.val = p1.val;
                    p1 = p1.next;
                } else {
                    p3.val = p2.val;
                    p2 = p2.next;
                }

            } else if (p1 != null && p2 == null) {
                p3.val = p1.val;
                p1 = p1.next;
            } else if (p1 == null && p2 != null) {
                p3.val = p2.val;
                p2 = p2.next;
            }
            if (p1 != null || p2 != null)
                p3.next = new ListNode(-1);
            p3 = p3.next;
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

