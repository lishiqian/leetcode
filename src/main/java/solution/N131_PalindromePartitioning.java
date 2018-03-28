package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return
 *
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 *
 */
//LeetCode131:Palindrome Partitioning
public class N131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<List<String>>();
        if(s == null || s.length() == 0) return ans;

        List<String> patrs = new ArrayList<String>();
        partition(s,0,patrs,ans);
        return ans;
    }

    public void partition(String s,int pos,List<String> parts,List<List<String>> ans){
        if(pos == s.length()){
            ans.add(new ArrayList<String>(parts));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            String temp = s.substring(pos, i+1);
            if(isPalindrome(temp)){
                parts.add(temp);
                partition(s,i + 1,parts,ans);
                parts.remove(parts.size()-1);
            }
        }

    }


    public boolean isPalindrome(String s){
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end){
            if(s.charAt(begin) != s.charAt(end))
                return false;
            begin++;
            end--;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(partition("aab"));
    }
}
