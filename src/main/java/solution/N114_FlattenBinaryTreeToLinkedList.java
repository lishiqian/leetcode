package solution;

import common.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example,
 * Given
 *
 *              1
 *             / \
 *            2   5
 *           / \   \
 *          3  4   6
 * The flattened tree should look like:
 *  1
 *   \
 *   2
 *    \
 *    3
 *     \
 *     4
 *      \
 *      5
 *       \
 *       6
 */
public class N114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        while (root != null){
            if(root.left != null) {
                TreeNode cur = root.left;
                while (cur.right != null){
                    cur = cur.right;
                }
                cur.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }


}
