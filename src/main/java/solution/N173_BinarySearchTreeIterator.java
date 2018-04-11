package solution;

import common.TreeNode;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class N173_BinarySearchTreeIterator {
    public class BSTIterator {
        TreeNode current = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        public BSTIterator(TreeNode root) {
            current = root;
            while (current != null){
                stack.push(current);
                current = current.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return current != null || !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            current = stack.pop();
            int val = current.val;
            current = current.right;
            while (current != null){
                stack.push(current);
                current = current.left;
            }
            return val;
        }
    }
}
