package solution;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */

/**
 * 编写一个函数求字符串数组的最长公共前缀
 */
public class N014_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen,strs[i].length());
        }

        int commonPrefixLen = minLen;
        for (int i = 0; i < minLen; i++) {
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if(strs[0].charAt(i) != strs[j].charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                commonPrefixLen = i;
                break;
            }
        }

        return strs[0].substring(0,commonPrefixLen);
    }
}
