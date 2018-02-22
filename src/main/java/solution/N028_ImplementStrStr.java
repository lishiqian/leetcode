package solution;

import org.junit.Test;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 */
public class N028_ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0) return 0;
        if(haystack.length() == 0) return -1;
        if(needle.length() == 0) return 0;
        return kmp(haystack,needle);
    }

    public int kmp(String src, String desc){
        int[] next = getNext(desc);
        int i = 0,j = 0;
        while (i < src.length() && j < desc.length()){
            if(src.charAt(i) == desc.charAt(j)){
                i++;
                j++;
            }else if(next[j] == -1){
                i++;
                j = 0;
            }else{
                j = next[j];
            }
        }

        if(j == desc.length()) return i - j;
        else return -1;
    }


    public int[] getNext(String str){
        if(str.length() == 1) return new int[]{-1};
        if(str.length() == 2) return new int[]{-1,0};

        int[] next = new int[str.length()];
        next[0] = -1;
        next[1] = 0;

        int pos = 2;
        int j = 0;
        while (pos < next.length){
            if(str.charAt(pos-1) == str.charAt(j)){
                next[pos++] = ++j;
            }else if(next[j] == -1){
                j = 0;
                pos++;
            }else {
                j = next[j];
            }
        }
        return next;
    }

    @Test
    public void test(){
        System.out.println(strStr("aaaabcabca","abc"));
    }
}
