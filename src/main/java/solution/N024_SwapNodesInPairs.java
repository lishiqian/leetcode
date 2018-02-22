package solution;

import common.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */

/**
 * 题目大意:
 * 给定一个链表,交换每两相邻节点,并返回它的头。
 * 例如,
 * 鉴于1 - > 2 - > 3 - > 4,您应该返回列表2 - > 1 - > 4 - > 3。
 * 你的算法应该只使用恒定的空间。你可能不修改列表中的值,只有节点本身可以改变。
 */
public class N024_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0);
        ListNode current = start;
        start.next = head;
        while (head != null && head.next != null){
            ListNode left = head;
            ListNode right = head.next;
            head = head.next.next;

            current.next = right;
            right.next = left;
            current = left;
        }

        if(head != null){
            current.next = head;
        }else{
            current.next = null;
        }

        return start.next;
    }
}
