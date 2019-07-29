package solution;

import org.junit.Test;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 *
 * Below is one possible representation of s1 = "great":
 *
 *         great
 *         /   \
 *        gr   eat
 *       / \   /  \
 *      g   r  e   at
 *     / \
 *    a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 *
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 *
 *          rgeat
 *         /    \
 *        rg    eat
 *       / \    /  \
 *      r   g  e   at
 *     / \
 *    a   t
 * We say that "rgeat" is a scrambled string of "great".
 *
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 *
 *          rgtae
 *         /    \
 *       rg    tae
 *      / \    /  \
 *     r   g  ta  e
 *    / \
 *   t   a
 * We say that "rgtae" is a scrambled string of "great".
 *
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *
 * Example 1:
 *
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 *
 *
 * 翻译：
 * 
 * 给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 *
 * 下图是字符串 s1 = "great" 的一种可能的表示形式。
 *
 *                    great
 *                    /    \
 *                  gr    eat
 *                 / \    /  \
 *                g   r  e   at
 *                           / \
 *                          a   t
 * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 *
 * 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
 *
 *                  rgeat
 *                 /    \
 *               rg    eat
 *              / \    /  \
 *             r   g  e   at
 *                        / \
 *                       a   t
 * 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
 *
 * 同样地，如果我们继续将其节点 "eat" 和 "at" 进行交换，将会产生另一个新的扰乱字符串 "rgtae" 。
 *
 *                 rgtae
 *                /    \
 *               rg    tae
 *              / \    /  \
 *             r   g  ta  e
 *                    / \
 *                   t   a
 * 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
 *
 * 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
 *
 * 示例 1:
 *
 * 输入: s1 = "great", s2 = "rgeat"
 * 输出: true
 * 示例 2:
 *
 * 输入: s1 = "abcde", s2 = "caebd"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/scramble-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N087_ScrambleString {
    /**
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        if(s1.equals(s2))
            return true;
        
        int letters[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if(letters[i] != 0)
                return false;
        }

        for (int i = 1; i < s1.length(); i++) {
            if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i)))
                return true;
            if(isScramble(s1.substring(0,i),s2.substring(s1.length() - i)) && isScramble(s1.substring(i),s2.substring(0,s1.length()-i)))
                return true;
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(isScramble("abc","bca"));
    }
}
