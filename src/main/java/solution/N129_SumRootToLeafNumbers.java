package solution;

import common.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * For example,
 *
 * 1
 * / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 *
 * Return the sum = 12 + 13 = 25.
 */
public class N129_SumRootToLeafNumbers {
//    public int sum = 0;
//    public int sumNumbers(TreeNode root) {
//        getSum(root,0);
//        return sum;
//    }
//
//    public void getSum(TreeNode root,int curVal){
//        if(root == null)
//            return;
//
//        curVal = curVal * 10 + root.val;
//        if(root.left == null && root.right == null)
//            sum += curVal;
//        getSum(root.left,curVal);
//        getSum(root.right,curVal);
//    }

    public int sumNumbers(TreeNode root) {
        return getSum(root,0);
    }

    public int getSum(TreeNode root,int curVal){
        if(root == null)
            return 0;
        curVal = curVal*10 + root.val;
        if(root.left == null && root.right == null)
            return curVal;
        return getSum(root.left,curVal) + getSum(root.right,curVal);
    }
}
