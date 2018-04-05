package solution;

import org.junit.Test;

/**
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 */
public class N151_ReverseWordsInAString {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        char[] c = s.toCharArray();

        reverse(c,0,c.length-1);
        rereverseWords(c,c.length);

        return removeSpace(c);
    }

    public void rereverseWords(char[] c,int n){
        int j = 0, i = 0;
        while (i < n){
            while (i < j || (i < n && c[i] == ' ')) i++;
            while (j < i || (j < n && c[j] != ' ')) j++;
            reverse(c,i,j-1);
        }
    }



    public String removeSpace(char[] c){
        int index = 0;
        int len = 0;

        while (index < c.length){
            while (index < c.length && c[index] == ' '){
                index++;
            }
            while (index < c.length && c[index] != ' '){
                c[len++] = c[index++];
            }
            if(index < c.length){
                c[len++] = ' ';
            }
        }

        if(len > 0 && c[len-1] == ' ') len--;
        return new String(c,0,len);
    }

    public void reverse(char[] ch,int begin,int end){
        while (begin < end){
            char t = ch[begin];
            ch[begin] = ch[end];
            ch[end] = t;

            begin++;
            end--;
        }
    }

    @Test
    public void test(){
        System.out.println(reverseWords("hello"));
        System.out.println(reverseWords("I am    a student"));
        System.out.println(reverseWords("hello world"));
        System.out.println(reverseWords(" hello world "));
        System.out.println(reverseWords(" "));
        System.out.println(reverseWords(" 1"));
        System.out.println(reverseWords("+---...2x+--x--+x-+-x2...---+"));
    }
}
