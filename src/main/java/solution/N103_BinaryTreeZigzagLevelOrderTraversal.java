package solution;

import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *  / \
 * 15  7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */

public class N103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;

        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();


        stack1.push(root);
        TreeNode node = null;

        while (!(stack1.isEmpty() && stack2.isEmpty())){
            List<Integer> rowList = new ArrayList<Integer>();
            while (!stack1.isEmpty()){
                node = stack1.pop();
                rowList.add(node.val);
                if(node.left != null)
                    stack2.push(node.left);
                if(node.right != null)
                    stack2.push(node.right);
            }
            if(!rowList.isEmpty()) ans.add(rowList);
            rowList = new ArrayList<Integer>();
            while (!stack2.isEmpty()){
                node = stack2.pop();
                rowList.add(node.val);
                //注意这里是先加右孩子，再加左孩子
                if(node.right != null)
                    stack1.push(node.right);
                if(node.left != null)
                    stack1.push(node.left);
            }
            if(!rowList.isEmpty()) ans.add(rowList);
        }

        return ans;
    }
}
