package solution;

import common.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class N107_BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode nLast = root;
        TreeNode nnLast = root;

        List<Integer> rowElement = new ArrayList<Integer>();

        while (!queue.isEmpty()){
            root = queue.poll();
            rowElement.add(root.val);

            if(root.left != null){
                queue.add(root.left);
                nnLast = root.left;
            }
            if(root.right != null){
                queue.add(root.right);
                nnLast = root.right;
            }

            if(root == nLast){
                nLast = nnLast;
                ans.add(0,rowElement);
                rowElement = new ArrayList<Integer>();
            }
        }
        return ans;
    }
}
