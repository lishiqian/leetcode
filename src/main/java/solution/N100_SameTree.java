package solution;

import common.TreeNode;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 * Example 2:
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 * Example 3:
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 */
public class N100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null) return q == null;
        if(q == null) return p == null;
        if(q.val != p.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
