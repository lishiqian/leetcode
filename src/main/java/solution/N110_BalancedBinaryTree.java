package solution;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *       3
 *      / \
 *     9  20
 *       /  \
 *     15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *       1
 *      / \
 *     2  2
 *    / \
 *   3  3
 *  / \
 * 4  4
 * Return false.
 */

import common.TreeNode;

/**
 * 题目大意：
 * 判断一颗二叉树是否为平衡二叉树
 */
public class N110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }

    public int getDepth(TreeNode root){
        if(root == null) return 0;

        int leftDepth = getDepth(root.left);
        if(leftDepth == -1)
            return -1;
        int rightDepth = getDepth(root.right);
        if(rightDepth == -1)
            return -1;

        if(Math.abs(leftDepth - rightDepth) > 1) return -1;
        return Math.max(leftDepth,rightDepth) + 1;
    }
}
