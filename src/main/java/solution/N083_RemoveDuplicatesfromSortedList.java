package solution;

import common.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */

/**
 * 题目大意：
 * 链表去重
 */
public class N083_RemoveDuplicatesfromSortedList {
//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode current = head;
//        while (current != null){
//            if(current.next != null){
//                if(current.val == current.next.val){
//                    current.next = current.next.next;
//                }else{
//                    current = current.next;
//                }
//            }else {
//                return head;
//            }
//        }
//        return head;
//    }
//
//
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null){
            if(current.next != null && current.val == current.next.val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return head;
    }
}
