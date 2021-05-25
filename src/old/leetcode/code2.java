package old.leetcode;

public class code2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp3 = result;
        //上次计算的进位
        int carry = 0;
        while (temp1 != null || temp2 != null) {
            int add = 0;
            if (temp1 == null)
                add = temp2.val;
            else if (temp2 == null)
                add = temp1.val;
            else add = temp1.val + temp2.val;
            if (add >= 10) {
                int n = add % 10;
                int _carry = add / 10;
                add = n == 0 ? carry : n + carry;
                temp3.val = add;
                //保存进位
                carry = _carry;
            } else {
                add = add + carry;
                if (add >= 10) {
                    int n = add % 10;
                    int _carry = add / 10;
                    add = n == 0 ? 0 : n + carry;
                    temp3.val = add;
                    //保存进位
                    carry = _carry;
                } else {
                    temp3.val = add;
                    carry = 0;
                }
            }
            if (temp1 != null)
                temp1 = temp1.next;
            if (temp2 != null)
                temp2 = temp2.next;
            if (temp1 != null || temp2 != null) {
                temp3.next = new ListNode(0);
                temp3 = temp3.next;
            }
        }
        if (carry != 0) {
            temp3.next = new ListNode(carry);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        //   l1.next = new ListNode(4);
        //  l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        // l2.next.next = new ListNode(4);
        ListNode result = new code2().addTwoNumbers(l1, l2);
        ListNode temp = result;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }

    }

}

class ListNode {
    public int val;
    public ListNode next; // 下一个链表对象

    public ListNode(int x) {
        val = x;
    } // 赋值链表的值
}