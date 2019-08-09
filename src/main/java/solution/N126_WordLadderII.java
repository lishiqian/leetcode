package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * For example,
 *
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * Note:
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * UPDATE (2017/1/20):
 * The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 */
public class N126_WordLadderII {
//    //超时
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> ans = new ArrayList<List<String>>();
//        if(!wordList.contains(endWord)) return ans;
//        Stack<String> visited = new Stack<String>();
//        visited.add(beginWord);
//
//        DFS(beginWord,endWord,wordList,visited,ans);
//        return ans;
//    }
//
//    public void DFS(String curWord, String endWord, List<String> wordList,Stack<String> visited,List<List<String>> ans){
//        for (int i = 0; i < curWord.length(); i++) {
//            char[] chars = curWord.toCharArray();
//            for (char c = 'a'; c <= 'z'; c++) {
//                chars[i] = c;
//                String nextWord = new String(chars);
//
//                if(nextWord.equals(endWord)){
//                    visited.add(nextWord);
//                    addToAns(visited,ans);
//                    visited.pop();
//                    return;
//                }
//
//                if(wordList.contains(nextWord) && !visited.contains(nextWord)){
//                    visited.add(nextWord);
//                    DFS(nextWord,endWord,wordList,visited,ans);
//                    visited.pop();
//                }
//            }
//        }
//    }
//
//
//    public void addToAns(Stack<String> visited,List<List<String>> ans){
//        if(ans.isEmpty()){
//            ans.add(new ArrayList<>(visited));
//        }else{
//            if(visited.size() > ans.get(0).size()){
//                return;
//            }else if(visited.size() == ans.get(0).size()){
//                ans.add(new ArrayList<>(visited));
//            }else{
//                ans.clear();
//                ans.add(new ArrayList<>(visited));
//            }
//        }
//    }





    @Test
    public void test(){

    }
}
