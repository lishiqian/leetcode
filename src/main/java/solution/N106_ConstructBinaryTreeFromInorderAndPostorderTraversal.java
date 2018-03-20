package solution;

import common.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */


/**
 * 题目大意：
 * 给定一个二叉树的后续
 * 遍历和中序遍历，构建成一个二叉树
 */
public class N106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return create(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public TreeNode create(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd){
        if(inStart > inEnd) return null;
        if(postStart > postEnd) return null;

        TreeNode node = new TreeNode(postorder[postEnd]);

        for (int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == postorder[postEnd]){
                int pos = i;
                node.left = create(inorder,inStart,pos - 1,postorder,postStart,postStart + (pos - inStart) - 1);
                node.right = create(inorder,pos + 1,inEnd,postorder,postStart + (pos - inStart),postEnd-1);
                break;
            }
        }

        return node;
    }
}
