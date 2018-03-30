package solution;

import common.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Note: Do not modify the linked list.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */
public class N142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                break;
            }
        }

        if(fast == null || fast.next == null) return null;

        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
