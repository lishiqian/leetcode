package solution;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * For example:
 * Given the following binary tree,
 *
 *     1            <---
 *   /   \
 *  2     3         <---
 *  \     \
 *  5     4       <---
 *
 *
 * You should return [1, 3, 4].
 */
public class N199_BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        TreeNode nRight = root;
        TreeNode queueLast = root;
        while (!queue.isEmpty()){
            root = queue.poll();
            if(root.left != null) {
                queue.add(root.left);
                queueLast = root.left;
            }
            if(root.right != null) {
                queue.add(root.right);
                queueLast = root.right;
            }
            if(root == nRight){
                nRight = queueLast;
                result.add(root.val);
            }
        }

        return result;
    }
}
