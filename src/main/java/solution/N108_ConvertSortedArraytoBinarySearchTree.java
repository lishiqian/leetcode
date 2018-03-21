package solution;

import common.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class N108_ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return create(nums,0,nums.length - 1);
    }

    public TreeNode create(int[] nums,int begin,int end){
        if(begin > end) return null;

        int mid  = (begin + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = create(nums,begin,mid - 1);
        node.right = create(nums,mid + 1,end);
        return node;
    }
}
