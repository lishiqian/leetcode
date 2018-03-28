package solution;

import common.TreeNode;

/**
 * Given a binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * For example:
 * Given the below binary tree,
 *
 *    1
 *   / \
 *  2   3
 * Return 6.
 */
public class N124_BinaryTreeMaximumPathSum {
    public int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        getMaxPathSum(root);
        return maxValue;
    }

    public int getMaxPathSum(TreeNode root) {
        if(root == null) return 0;

        int lMaxValue = getMaxPathSum(root.left);
        int rMaxValue = getMaxPathSum(root.right);

        int curVal = root.val;
        if(lMaxValue > 0) curVal += lMaxValue;
        if(rMaxValue > 0) curVal += rMaxValue;

        maxValue = Math.max(maxValue,curVal);

        return Math.max(root.val,Math.max(lMaxValue,rMaxValue) + root.val);
    }
}
