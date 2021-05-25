package old.SwordOffer;

/**
 * 题目：反转链表
 * 介绍：输入一个链表，反转链表后，输出新链表的表头
 * 思路：原地置换,就是不断地将结点指向它的前一个结点，然后头节点要一直保持在逆转后的头部就OK
 * 需要三个变量，1： 头节点 head 2.当前节点 current 3.下一节点 next
 * 在while中,比如链表是 null->1->2->3,
 * 1.current.next=head  执行过current就变成1->null,next还是2->3
 * 2.head=current 头节点嘛，一直保持在新链表的头部,head这时就是1->null
 * 3.current=next current继续指向原链表的下一结点，把next存的结点拿过来,这时候current是2->3
 * 4.next=next.next next继续往后走，就是3->null了
 * 这时候head为1->null,current为2->3,next为3->null
 * 按照上面思路，下一次while结束就是:
 * head:2->1>null current 3->null next->null
 * head:3->2->1->null current:null next:null
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        ListNode next = head.next;
        head = null;
        while (current != null) {
            current.next = head;
            head = current;
            current = next;
            if (next != null)
                next = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        System.out.println(new ReverseList().ReverseList(node));
    }

}

