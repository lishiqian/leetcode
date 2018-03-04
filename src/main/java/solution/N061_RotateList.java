package solution;

import common.ListNode;
import org.junit.Test;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 *
 * Example:
 *
 * Given 1->2->3->4->5->NULL and k = 2,
 *
 * return 4->5->1->2->3->NULL.
 */

/**
 * 题目大意：
 * 旋转链表
 */
public class N061_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int len = 0;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy,slow = dummy;

        while (fast.next != null){
            fast = fast.next;
            len++;
        }

        for (int i = len - k % len; i > 0; i--) {
            slow = slow.next;
        }

        fast.next = dummy.next;
        dummy = slow.next;
        slow.next = null;

        return dummy;
    }

    @Test
    public void test(){
        //ListNode listNode = rotateRight(ListNode.creat(new int[]{1, 2, 3, 4, 5}), 2);
        //System.out.println(listNode);

        ListNode listNode = rotateRight(ListNode.creat(new int[]{1, 2, 3, 4, 5}), 2);
        System.out.println(listNode);
    }
}
