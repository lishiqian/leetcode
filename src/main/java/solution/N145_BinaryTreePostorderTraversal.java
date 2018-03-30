package solution;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree [1,null,2,3],
 *
 * 1
 *  \
 *   2
 *  /
 * 3
 *
 *
 * return [3,2,1].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class N145_BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorderList = new ArrayList<Integer>();
        if(root == null) return postorderList;

        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);

        while (!stack1.isEmpty()){
            root = stack1.pop();
            stack2.push(root);

            if(root.left != null)
                stack1.push(root.left);
            if(root.right != null)
                stack1.push(root.right);
        }

        while (!stack2.isEmpty()){
            postorderList.add(stack2.pop().val);
        }

        return postorderList;
    }
}
