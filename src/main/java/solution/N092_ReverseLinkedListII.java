package solution;

import common.ListNode;
import org.junit.Test;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class N092_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode reversePosBefore = dummy;
        ListNode reversePos = null;
        for (int i = 0; i < m - 1; i++) {
            reversePosBefore = reversePosBefore.next;
        }
        reversePos = reversePosBefore.next;

        ListNode current = reversePos.next;
        ListNode currentBefore = reversePos;
        for (int i = m; i < n; i++) {
            ListNode temp = current.next;
            current.next = currentBefore;
            currentBefore = current;
            current = temp;
        }

        reversePos.next = current;
        reversePosBefore.next = currentBefore;
        return dummy.next;
    }


    @Test
    public void test(){
        ListNode head = ListNode.creat(new int[]{3, 5});
        reverseBetween(head,1,2);
    }
}
