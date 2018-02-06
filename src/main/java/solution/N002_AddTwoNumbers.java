package solution;

import common.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

/**
 * 题目大意:
 * 给你两个非空链表代表两个非负整数
 * 每个数字的每一位存储在一个单独的节点中，并且反向排序
 * 求出两个数字的和并返回一个链表
 * 你可假设这两个数字没有以0开头，除了数字0自己
 */
public class N002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        int carryBit = 0; //进位数
        int sum = 0;

        while (l1 != null || l2 != null){
            if(l1 != null && l2 != null){
               sum = l1.val + l2.val + carryBit;
            }else if(l1 != null){
                sum = l1.val + carryBit;
            }else{
                sum = l2.val + carryBit;
            }


            carryBit = sum/10;
            sum %= 10;


            ListNode node = new ListNode(sum);
            if(head == null){
                head = node;
                current = node;
            }else{
                current.next = node;
                current = node;
            }

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }



        if(carryBit != 0){
            ListNode node = new ListNode(carryBit);
            current.next = node;
        }

        return head;
    }
}
