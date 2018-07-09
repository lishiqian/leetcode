package solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class N076_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] count = new int[58];
        int[] tCount = new int[58];
        Queue<Character> windows = new LinkedList<Character>();

        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i) - 'A']++;
        }

        int minStart = 0;
        int minEnd = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            windows.add(c);
            ++count[c - 'A'];
            while (hasAll(count,tCount)){
               if(i - start < min){
                   minEnd = i;
                   minStart = start;
                   min = i - start;
               }
                Character old = windows.poll();
               --count[old - 'A'];
               start++;
            }
        }
        if(min == Integer.MAX_VALUE) return  "";

        return s.substring(minStart,minEnd+1);
        
    }
    
    public boolean hasAll(int[] count,int[] tCount){
        for (int i = 0; i < count.length; i++) {
            if(count[i] < tCount[i]){
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        N076_MinimumWindowSubstring n076_minimumWindowSubstring = new N076_MinimumWindowSubstring();
        String s = n076_minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}
