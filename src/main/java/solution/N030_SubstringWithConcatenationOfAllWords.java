package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 *
 * You should return the indices: [0,9].
 * (order does not matter).
 */

/**
 * 题意：给定一个字符串s, 以及一个字符串数组words, 字符串数组中的字符串长度都是一样的。
 * 找出s中所有的子串，要求这些子串是字符串数组中的所有字符串拼接的结果，字符串拼接的时候顺序可以随意。
 * 最终返回子串开始的位置。
 */
public class N030_SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> counts = new HashMap<String,Integer>();
        for (int i = 0; i < words.length; i++) {
            counts.put(words[i],counts.get(words[i]) == null ? 1 : counts.get(words[i]) + 1);
        }
        List<Integer> indexs = new ArrayList<Integer>();
        int len = words[0].length(),num = words.length,slen = s.length();
        for (int i = 0; i < slen - len * num + 1; i++) {
            HashMap<String,Integer> seen = new HashMap<String,Integer>();
            int j = 0;
            while (j < num){
                String word = s.substring(i + j * len,i + (j + 1) * len);
                if(counts.containsKey(word)){
                    seen.put(word,seen.get(word) == null ? 1 : seen.get(word) + 1);
                    if(seen.get(word) > counts.get(word))
                        break;
                }else {
                    break;
                }
                j++;
            }

            if(j == num) indexs.add(i);
        }
        return indexs;
    }
}
