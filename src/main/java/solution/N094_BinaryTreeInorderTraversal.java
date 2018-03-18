package solution;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree [1,null,2,3],
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目大意：
 * 求二叉树的非递归遍历
 */
public class N094_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root != null) stack.push(root);

        while (!stack.isEmpty()){
            while (root != null && root.left != null){
                stack.push(root.left);
                root = root.left;
            }

            root = stack.pop();
            ans.add(root.val);
            if(root.right != null) stack.push(root.right);
            root = root.right;
        }

        return ans;
    }

    @Test
    public void test(){
        TreeNode root = TreeNode.stringToTreeNode("[]");
        List<Integer> integers = inorderTraversal(root);
        System.out.println(integers);
    }
}
