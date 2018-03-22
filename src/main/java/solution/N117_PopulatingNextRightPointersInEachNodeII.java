package solution;

import common.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 *
 * What if the given tree could be any binary tree? Would your previous solution still work?
 *
 * Note:
 *
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *      1
 *     / \
 *    2  3
 *   / \  \
 *  4  5  7
 * After calling your function, the tree should look like:
 *       1 -> NULL
 *     /  \
 *    2 -> 3 -> NULL
 *   / \    \
 *  4-> 5 -> 7 -> NULL
 */
public class N117_PopulatingNextRightPointersInEachNodeII {
//    public void connect(TreeLinkNode root) {
//        if(root == null) return;
//        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
//        queue.add(root);
//
//        while (!queue.isEmpty()){
//            int len = queue.size();
//            for (int i = 0; i < len; i++) {
//                TreeLinkNode node = queue.poll();
//                if(i < len - 1) node.next = queue.peek();
//                if(node.left != null) queue.add(node.left);
//                if(node.right != null) queue.add(node.right);
//            }
//        }
//    }

    //O(1)空间
    public void connect(TreeLinkNode root){
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode t = dummy;
        while (root != null){
            if(root.left != null){
                t.next = root.left;
                t = t.next;
            }
            if(root.right != null){
                t.next = root.right;
                t = t.next;
            }
            root = root.next;
            if(root == null){
                t = dummy;
                root = dummy.next;
                dummy.next = null;
            }
        }
    }

}
