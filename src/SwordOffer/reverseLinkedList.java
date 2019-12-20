package SwordOffer;

import java.util.ArrayList;
/**
 * 题目：从尾到头打印链表
 * 介绍：输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 思路：链表原地置换
 */
public class reverseLinkedList {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null) {
            return result;
        }
        ListNode current = listNode; //当前节点
        ListNode next = current.next; //下一个节点
        listNode = null; //头结点置空
        while (current != null) {
            current.next = listNode; //当前节点指向头结点
            listNode = current; // 头结点改为当前结点
            //继续往后走
            current = next;
            if (current != null) {
                next = current.next;
            }
        }
        while (listNode != null) {
            result.add(listNode.val);
            listNode = listNode.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        System.out.println(new reverseLinkedList().printListFromTailToHead(node));
    }


}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}