package solution;

import common.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */

/**
 * 题目大意：
 * 给你一个链表，让小于value的值划分链表左侧，其他的在链表的右侧，保持节点相对位置不变
 */
public class N086_PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode dummyLeft = new ListNode(0);
        ListNode dummyRight = new ListNode(0);
        ListNode curLeft = dummyLeft;
        ListNode curRight = dummyRight;

        while (head != null){
            if(head.val < x){
                curLeft.next = head;
                curLeft = head;
            }else{
                curRight.next = head;
                curRight = head;
            }
            head = head.next;
        }

        curLeft.next = dummyRight.next;
        curRight.next = null;
        return dummyLeft.next;
    }
}
