package solution;

import common.ListNode;
import common.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *      0
 *     / \
 *  -3   9
 *  /   /
 * -10  5
 */

/**
 * 题目大意：
 * 给你一个有序的链表，将其构建成一个AVL树；
 * https://www.cnblogs.com/hellowooorld/p/6624709.html
 */
public class N109_ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        return create(head,null);
    }

    public TreeNode create(ListNode start,ListNode end){
        if(start == end) return null;
        ListNode fast = start;
        ListNode slow = start;

        while (fast != end && fast.next != end){
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = create(start,slow);
        node.right = create(slow.next,end);
        return node;
    }
}
