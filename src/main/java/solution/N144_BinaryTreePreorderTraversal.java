package solution;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree [1,null,2,3],
 *  1
 *   \
 *    2
 *   /
 *  3
 * return [1,2,3].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class N144_BinaryTreePreorderTraversal {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> preorderList = new ArrayList<Integer>();
//        if(root == null) return preorderList;
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                preorderList.add(root.val);
//                stack.push(root);
//                root = root.left;
//            }
//            if (!stack.isEmpty()){
//                root = stack.pop();
//                root = root.right;
//            }
//        }
//
//        return preorderList;
//    }

    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> preorderList = new ArrayList<Integer>();
        if(root == null) return preorderList;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()){
            root = stack.pop();
            preorderList.add(root.val);

            if(root.right != null)
                stack.push(root.right);
            if(root.left != null)
                stack.push(root.left);
        }

        return preorderList;
    }
}
