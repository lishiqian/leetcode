package solution;

import org.junit.Test;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 *
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 *
 */
public class N125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        int begin = 0, end = s.length() - 1;

        while (begin < end){
            while (begin < end && !isWord(s.charAt(begin)) && !Character.isDigit(s.charAt(begin)))
                begin++;
            while (begin < end && !isWord(s.charAt(end)) && !Character.isDigit(s.charAt(end)))
                end--;

            if(!equals(s.charAt(begin++),s.charAt(end--)))
                return false;
        }

        return true;
    }

    public boolean isWord(char c){
        return (c >= 'a' && c <= 'z') || c >= 'A' && c <= 'Z';
    }

    public boolean equals(char c1,char c2){
        if(isWord(c1) && isWord(c2)){
            if(c1 >= 'A' && c1 <= 'Z'){ //大写转小写
                c1 = (char)(c1 - 'A' + 'a');
            }
            if(c2 >= 'A' && c2 <= 'Z'){ //大写转小写
                c2 = (char)(c2 - 'A' + 'a');
            }

            return c1 == c2;
        } else{
            return c1 == c2;
        }
    }

    @Test
    public void test(){
        isPalindrome("0P");
    }
}
