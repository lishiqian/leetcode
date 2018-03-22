package solution;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *            5
 *           / \
 *         4   8
 *        /   / \
 *       11  13  4
 *      /  \    / \
 *     7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class N113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        getPath(root,sum,ans,path);
        return ans;
    }

    public void getPath(TreeNode root,int sum,List<List<Integer>> ans,List<Integer> path){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(root.val == sum){
                path.add(root.val);
                ans.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        path.add(root.val);
        getPath(root.left,sum - root.val,ans,path);
        getPath(root.right,sum - root.val,ans,path);
        path.remove(path.size() - 1);
    }
}
