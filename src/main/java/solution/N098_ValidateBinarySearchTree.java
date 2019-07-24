package solution;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 * 2
 * / \
 * 1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class N098_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        midOrder(root,list);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i-1) >= list.get(i)){
                return false;
            }
        }
        return true;
    }

    public void midOrder(TreeNode root,List<Integer> list){
        if(root != null){
            midOrder(root.left,list);
            list.add(root.val);
            midOrder(root.right,list);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.stringToTreeNode("[10,5,15,null,null,6,20]");
        boolean validBST = new N098_ValidateBinarySearchTree().isValidBST(treeNode);
        System.out.println(validBST);
    }
}
