package solution;

import common.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */
public class N141_LinkedListCycle {
//    public boolean hasCycle(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//
//        while (fast != null){
//            slow = slow.next;
//            fast = fast.next;
//            if(fast != null){
//                fast = fast.next;
//            }else{
//                return false;
//            }
//
//            if(fast == slow) return true;
//        }
//
//        return false;
//    }

    public boolean hasCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow)
                return true;
        }

        return false;
    }
}
