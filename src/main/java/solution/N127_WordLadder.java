package solution;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * For example,
 *
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * UPDATE (2017/1/20):
 * The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 */
public class N127_WordLadder {
    //超时
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if(!wordList.contains(endWord)) return 0;
//        HashMap<String,Integer> lenMap = new HashMap<String, Integer>();
//        lenMap.put(beginWord,1);
//        if(wordList.contains(beginWord))
//            wordList.remove(beginWord);
//
//        Queue<String> queue = new LinkedList<String>();
//        queue.add(beginWord);
//
//        while (!queue.isEmpty()){
//            String curWord = queue.poll();
//            for (int i = 0; i < curWord.length(); i++) {
//                StringBuilder nextWordBuilder = new StringBuilder(curWord);
//                for (char c = 'a'; c <= 'z'; c++) {
//                    nextWordBuilder.setCharAt(i,c);
//                    String nextWord = nextWordBuilder.toString();
//
//                    if(nextWord.equals(endWord))
//                        return lenMap.get(curWord) + 1;
//
//                    if(nextWord.equals(curWord))
//                        continue;
//
//                    if(wordList.contains(nextWord) && !lenMap.containsKey(nextWord)){
//                        queue.add(nextWord);
//                        wordList.remove(nextWord);
//                        lenMap.put(nextWord,lenMap.get(curWord) + 1);
//                    }
//                }
//
//            }
//
//        }
//        return 0;
//    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        queue.add(null); //以null来判断深度

        HashSet<String> wordSet = new HashSet<>(wordList);//对单词进行去重复处理 说好的不重复呢？
        HashSet<String> visited = new HashSet<String>();

        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()){
            String curWord = queue.poll();
            if(curWord != null) {
                for (int i = 0; i < curWord.length(); i++) {
                    char[] chars = curWord.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;

                        String nextWord = new String(chars);

                        if(nextWord.equals(endWord))
                            return level + 1;

                        if(wordSet.contains(nextWord) && !visited.contains(nextWord)){
                            queue.add(nextWord);
                            visited.add(nextWord);
                        }
                    }
                }
            }else{
                level ++;
                if(!queue.isEmpty())
                    queue.add(null);
            }
        }

        return 0;
    }
}
