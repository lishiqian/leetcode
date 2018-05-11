package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.
 *
 * Return all such possible sentences.
 *
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 *
 * A solution is ["cats and dog", "cat sand dog"].
 *
 * UPDATE (2017/1/4):
 * The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 */
public class N140_WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> curCut = new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        DFS(0,s,wordDict,curCut,result);
        return result;
    }

    public void DFS(int begin,String s,List<String> wordDict,List<String> curCut,List<String> result){
        if(begin == s.length()){
            result.add(join(curCut,' '));
            return;
        }

        for (int i = begin; i < s.length(); i++) {
            String temp = s.substring(begin,i + 1);
            if(wordDict.contains(temp)){
                curCut.add(temp);
                DFS(i + 1,s,wordDict,curCut,result);
                curCut.remove(curCut.size() - 1);
            }
        }
    }

    public String join(List<String> list,char c){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if(i != list.size() - 1){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
