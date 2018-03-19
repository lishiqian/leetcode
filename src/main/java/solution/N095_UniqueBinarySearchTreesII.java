package solution;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
//https://www.tianmaying.com/tutorial/LC95
public class N095_UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if(n < 1) return new ArrayList<TreeNode>();
        return generateTrees(1,n);
    }

    public List<TreeNode> generateTrees(int start,int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();

        if(start > end){
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees(start,i - 1);
            List<TreeNode> right = generateTrees(i + 1,end);
            for (TreeNode leftT : left) {
                for (TreeNode rightT : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftT;
                    root.right = rightT;
                    list.add(root);
                }
            }
        }
        return list;
    }

    @Test
    public void test(){
        generateTrees(3);
    }
}
