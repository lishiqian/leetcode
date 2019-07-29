package solution;

import org.junit.Test;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 */
public class N097_InterleavingString {
    //暴力地柜
//    public boolean isInterleave(String s1, String s2, String s3) {
//        return interleave(s1, 0, s2, 0, s3, 0);
//    }
//
//
//    public boolean interleave(String s1, int i1, String s2, int i2, String s3, int i3) {
//        if (i1 == s1.length() && i2 == s2.length() && i3 == s3.length())
//            return true;
//        if (i3 >= s3.length())
//            return false;
//        boolean result = false;
//        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
//            result = result || interleave(s1, i1 + 1, s2, i2, s3, i3 + 1);
//        }
//        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
//            result = result || interleave(s1, i1, s2, i2 + 1, s3, i3 + 1);
//        }
//        return result;
//    }

    /**
     * 动态规划
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        boolean[][] flag = new boolean[s1.length() + 1][s2.length() + 1];
        flag[0][0] = true;

        for (int i = 0; i <= s1.length(); i++) {
            for(int j = 0;j <= s2.length(); j++){
                if(i + j > 0) {
                    flag[i][j] = (i > 0 && flag[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (j > 0 && flag[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }

        return flag[s1.length()][s2.length()];
    }

    @Test
    public void test(){
        System.out.println(isInterleave("aabcc","dbbca","aadbbcbcac"));
        System.out.println(isInterleave("a","b","ab"));
        System.out.println(isInterleave("ab","ab","aabb"));
        System.out.println(isInterleave("aabcc","dbbca","aadbbbaccc"));
    }
}
