package solution;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *   /   \
 *  15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class N102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
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
                ans.add(rowElement);
                rowElement = new ArrayList<Integer>();
            }
        }
        return ans;
    }
}
