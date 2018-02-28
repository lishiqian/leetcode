package solution;

import sun.plugin.javascript.navig.Array;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 *
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note: All inputs will be in lower-case.
 */
public class N049_GroupAnagrams {
    //https://www.cnblogs.com/grandyang/p/4385822.html
    //核心思想：统计每个字符出现的次数，生成一个字符串，那么相同组生产的字符串必然相同
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resList = new ArrayList<List<String>>();
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        int[] hash = new int[26];

        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                hash[strs[i].charAt(j) - 'a']++;
            }
            String keyGroup = arrayToString(hash);
            if(map.containsKey(keyGroup)){
                map.get(keyGroup).add(strs[i]);
            }else{
                ArrayList<String> group = new ArrayList<String>();
                group.add(strs[i]);
                map.put(keyGroup,group);
            }
        }

        Set<Map.Entry<String, List<String>>> entries = map.entrySet();
        Iterator<Map.Entry<String, List<String>>> iterator = entries.iterator();
        while (iterator.hasNext()){
            resList.add(iterator.next().getValue());
        }
        return resList;
    }

    public String arrayToString(int[] hash){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            sb.append(hash[i]);
            sb.append('!');
            hash[i] = 0;
        }
        return sb.toString();
    }
}
