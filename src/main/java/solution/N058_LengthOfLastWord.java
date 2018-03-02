package solution;

import org.junit.Test;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 */

/**
 * 题目大意:
 * 求出字符串最后一个单词的长度。
 */
public class N058_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int start = -1,end = -1;
        boolean isWord = false;
        int index = s.length() - 1;
        while (index >= 0){
            if(!isWord){
                if(isWord(s.charAt(index))){
                    end = index;
                    isWord = true;
                }
            }else{
                if(!isWord(s.charAt(index))){
                    start = index + 1;
                    break;
                }
            }
            index--;
        }

        if(end == -1) return 0;
        else if(start == -1) return end + 1;
        else return end - start + 1;
    }

    public boolean isWord(char ch){
        if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) return true;
        return false;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLastWord("hello world!"));
    }


}
