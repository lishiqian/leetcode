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
        int left = 0;
        List<String> result = new ArrayList<>();

        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            String line = justfy(left,right,words,maxWidth);
            result.add(line);
            left = right + 1;
        }

        return result;
    }

    /**
     * 找到当前能填充最大的单词数的索引
     * @param left
     * @param words
     * @param maxWidth
     * @return
     */
    public int findRight(int left, String[] words, int maxWidth){
        int right = left;
        int sum = words[right++].length();

        while (right < words.length && sum + 1 + words[right].length() <= maxWidth)
            sum += 1 + words[right++].length();

        return right - 1;
    }

    /**
     * 按情况填充空格
     * @param left
     * @param right
     * @param words
     * @param max
     * @return
     */
    public String justfy(int left, int right, String[] words, int maxWidth){
        boolean isLastLine = right == words.length - 1;
        int wordNum = right - left + 1;
        int totalSpace = maxWidth - wordLength(left,right,words);
        int numSpace = wordNum > 1? totalSpace / (wordNum - 1) : 0;
        int modSpace = wordNum > 1? totalSpace % (wordNum - 1) : 0;
        StringBuilder sb = new StringBuilder();
        sb.append(words[left]);

        if(!isLastLine){
            for (int i = 1; i < wordNum; i++) {
                if(i < modSpace + 1) back(sb,numSpace + 1);
                else back(sb,numSpace);
                sb.append(words[left + i]);
            }
        }else{
            for (int i = 1; i < wordNum; i++) {
                back(sb,1);
                sb.append(words[left + i]);
            }
        }
        //填充剩余长度
        back(sb,maxWidth - sb.length());

        return sb.toString();
    }

    /**
     * 计算字母长度
     * @param left
     * @param right
     * @param words
     * @return
     */
    public int wordLength(int left, int right, String[] words){
        int length = 0;

        for (int i = left; i <= right; i++) {
            length += words[i].length();
        }

        return length;
    }

    /**
     * 补充空格数量
     * @param sb
     * @param n
     */
    public void back(StringBuilder sb, int n){
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
    }



    @Test
    public void test(){
        System.out.println(fullJustify(new String[]{"What","must","be","acknowledgment","shall","be."},16));
    }
}
