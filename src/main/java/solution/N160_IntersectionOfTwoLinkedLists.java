package solution;

import common.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
*
*
* For example, the following two linked lists:
*
* A:          a1 → a2
*                     ↘
*                     c1 → c2 → c3
*                     ↗
* B:     b1 → b2 → b3
* begin to intersect at node c1.
 */
public class N160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = 0,bLen = 0;
        ListNode curA = headA,curB = headB;
        while (curA != null) {
            aLen++;
            curA = curA.next;
        }
        while (curB != null){
            bLen++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;
        if(aLen > bLen){
            for (int i = aLen - bLen; i > 0; i--) {
                curA = curA.next;
            }
        }else{
            for (int i = bLen - aLen; i > 0; i--) {
                curB = curB.next;
            }
        }

        while (curA != curB){
            curA = curA.next;
            curB = curB.next;
        }

        return curA;
    }
}
