package solution;

import org.junit.Test;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
//http://blog.csdn.net/u012501459/article/details/46622501
public class N096_UniqueBinarySearchTrees {

    //递归
//    public int numTrees(int n) {
//        if(n == 0 || n == 1) return 1;
//
//        int result = 0;
//        for (int i = 0; i < n; i++) {
//            result += numTrees(i) * numTrees(n - i - 1);
//        }
//
//        return result;
//    }


    public int numTrees(int n) {
        if(n == 0 || n == 1) return 1;

        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                g[i] += g[j] * g[i-j-1];
            }
        }

        return g[n];
    }

    @Test
    public void test(){
        System.out.println(numTrees(3));
    }


}
