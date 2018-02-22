package solution;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */

import common.ListNode;

/**
 * 题目大意:
 * 归并两个排序链表,归并后依然有序
 */
public class N021_MergeTwoSortedLists {
    //循环
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode start = new ListNode(0);
//        ListNode current = start;
//        while (l1 != null && l2 != null){
//            if(l1.val < l2.val){
//                current.next = l1;
//                l1 = l1.next;
//            }else{
//                current.next = l2;
//                l2 = l2.next;
//            }
//            current = current.next;
//        }
//
//        if(l1 != null) current.next = l1;
//        if(l2 != null) current.next = l2;
//        return start.next;
//    }

    //递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
