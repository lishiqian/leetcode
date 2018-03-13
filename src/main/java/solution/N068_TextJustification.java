package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 */

/**
 * 题目大意：
 * 给定一组单词和一个长度L，对文本进行格式化，使每一行都有确切的L字符，并且完全（左右）是正确的。
 * 你应该用贪婪的方式来表达你的话语;也就是说，在每一行中尽可能多地写单词。在必要时垫额外的空间，这样每一行都有正确的L字符。
 * 单词之间的额外空格应该尽可能均匀地分布。如果一条直线上的空间数不均匀地在单词之间进行分配，那么左边的空槽将被分配的空间多于右边的槽。
 * ps:遍历完所有单词之后需要特殊处理最后一行，这一行是居左对齐的，每个单词之间只有一个空格，处理完这行的单词之后，在后面补齐空格就可以了
 */
public class N068_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> resList = new ArrayList<String>();
        int startIndex = 0;
        while (startIndex < words.length){
            //得到一行可以容纳最多的字符串个数
            int wordCount = 0;
            int sumWordLen = 0;
            for (int i = 0; (startIndex + i < words.length) && (sumWordLen + words[startIndex + i].length() < maxWidth); i++) {
                wordCount = i;
                sumWordLen += words[startIndex + i].length();
            }

            if(wordCount == 0){
                sumWordLen = words[startIndex].length();
            }

            //拼接字符串
            String lineStr = mergeStr(words, startIndex, wordCount,sumWordLen,maxWidth);
            resList.add(lineStr);

            startIndex = startIndex + wordCount + 1;
        }

        return resList;
    }

    public String mergeStr(String[] words,int startIndex,int wordCount,int sumWordLen,int maxWidth){
        StringBuilder sb = new StringBuilder(maxWidth);
        int spaceCount = (maxWidth - sumWordLen);
        sb.append(words[startIndex]);
        if(startIndex + wordCount + 1 < words.length) {
            if (wordCount > 0) {
                int addSpaceCount = spaceCount / (wordCount);//添加空格次数
                int modSpaceCount = spaceCount % (wordCount);//空格除不尽余数
                for (int i = startIndex + 1; i <= startIndex + wordCount; i++) {
                    for (int j = 0; j < addSpaceCount; j++) {
                        sb.append(' ');
                    }
                    if (modSpaceCount > 0) {
                        sb.append(' ');
                        modSpaceCount--;
                    }
                    sb.append(words[i]);
                }
            } else {
                for (int j = 0; j < spaceCount; j++) {
                    sb.append(' ');
                }
            }
        }else{ //最后一行特殊处理
            for (int i = startIndex + 1; i <= startIndex + wordCount; i++){
                sb.append(' ');
                sb.append(words[i]);
                spaceCount--;
            }

            while (spaceCount > 0){
                sb.append(' ');
            }
        }

        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(fullJustify(new String[]{"What","must","be","shall","be."},12));
    }
}
