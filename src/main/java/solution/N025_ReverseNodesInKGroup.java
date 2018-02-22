package solution;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * Only constant memory is allowed.
 *
 * For example,
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 */

import common.ListNode;

/**
 * 题目大意:
 * 给定一个链表，可以一次反转链表k的节点，并返回其修改后的列表。
 *
 * k是一个正整数，小于或等于链表的长度。
 * 如果节点的数量不是k的倍数，那么最后的左外节点应该保持原样。
 *
 * 您可能不会更改节点中的值，只有节点本身可能被更改。
 *
 * 只允许保持恒定的内存。
 *
 * 例如,
 * 给定这个链表:1-2-3-4-5
 *
 * 对于k=2，你应该返回:2-1-4-4-3-5
 *
 * 对于k=3，你应该返回:3-2-1-4-5
 */
public class N025_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k){
            cur = cur.next;
            count++;
        }

        if(count == k){
            cur = reverseKGroup(cur,k);
            while (count-- > 0){
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }
}
