package solution;

import java.util.Arrays;
import java.util.List;

/**
 * @author lishiqian
 * @Date:Created in 2018/2/22 18:26
 */
public class N030_SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            int firstIndex = s.indexOf(words[i]);
            int lastIndex = s.lastIndexOf(words[i]);

            min = Math.min(min,firstIndex);
            max = Math.max(max,lastIndex + words.length);
        }

        return Arrays.asList(min,max);
    }
}
