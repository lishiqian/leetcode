package solution;

import common.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 */

/**
 * 题目大意：
 * 给定一个二叉树的前序遍历和中序遍历，构建成一个二叉树
 */
public class N105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return create(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode create(int[] preorder, int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        if(preStart > preEnd) return null;
        if(inStart > inEnd) return null;

        TreeNode node = new TreeNode(preorder[preStart]);

        for (int i = inStart; i <= inEnd; i++) {
            if(preorder[preStart] == inorder[i]){
                int pos = i;
                node.left = create(preorder,preStart+1,preStart + (pos - inStart),inorder,inStart,pos-1);
                node.right = create(preorder,preStart + (pos - inStart) + 1,preEnd,inorder,pos + 1,inEnd);
                return node;
            }
        }
        return node;
    }
}
