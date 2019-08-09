package solution;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Example 1:
 *
 * Input: [1,3,null,null,2]
 *
 *     1
 *    /
 *   3
 *    \
 *     2
 *
 * Output: [3,1,null,null,2]
 *
 *     3
 *    /
 *   1
 *    \
 *     2
 * Example 2:
 *
 * Input: [3,1,4,null,null,2]
 *
 *     3
 *    / \
 *   1   4
 *      /
 *     2
 *
 * Output: [2,1,4,null,null,3]
 *
 *      2
 *     / \
 *    1   4
 *       /
 *      3
 * Follow up:
 *
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 */
public class N099_RecoverBinarySearchTree {
//    //O(n)空间复杂度
//    public void recoverTree(TreeNode root) {
//        List<TreeNode> orderList = new ArrayList<TreeNode>();
//        midOrder(root,orderList);
//        sortVal(orderList);
//    }
//
//    public void midOrder(TreeNode root, List<TreeNode> orderList){
//        if(root != null){
//            midOrder(root.left,orderList);
//            orderList.add(root);
//            midOrder(root.right,orderList);
//        }
//    }
//
//    public void sortVal(List<TreeNode> orderList){
//        for (int i = 0; i < orderList.size(); i++) {
//            for (int j = 0; j < orderList.size() - i - 1; j++) {
//                if(orderList.get(j).val > orderList.get(j+1).val){
//                    int temp = orderList.get(j).val;
//                    orderList.get(j).val = orderList.get(j + 1).val;
//                    orderList.get(j + 1).val = temp;
//                }
//            }
//        }
//    }

    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    TreeNode pre = null;
    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        /*******************************************************/
        if(pre != null && root.val < pre.val) {
            //第一次遇到逆序对
            if(first==null){
                first = pre;
                second = root;
                //第二次遇到逆序对
            }else{
                second = root;
            }
        }
        pre = root;
        /*******************************************************/
        inorderTraversal(root.right);
    }

    @Test
    public void test(){
        TreeNode root = TreeNode.stringToTreeNode("[4,6,2,7,5,3,1,null,null,null,null,null,null,null,null]");
        recoverTree(root);
        System.out.println(root);
    }
}
