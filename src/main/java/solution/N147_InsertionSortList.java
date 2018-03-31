package solution;

import common.ListNode;

/**
 * Sort a linked list using insertion sort.
 */
public class N147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);

        while (head != null){
            ListNode temp = head;
            head = head.next;

            ListNode cur = dummy;
            while (cur.next != null && cur.next.val < temp.val){
                cur = cur.next;
            }
            temp.next = cur.next;
            cur.next = temp;
        }

        return dummy.next;
    }
}
