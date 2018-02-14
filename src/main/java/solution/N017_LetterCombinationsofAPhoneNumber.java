package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * 题目有图片
 */
public class N017_LetterCombinationsofAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> resultList = new LinkedList<String>();
        if(digits == null || digits.length() == 0) return resultList;
        String[] mapping = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        resultList.add("");

        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            char[] chArray = mapping[x].toCharArray();
            while (resultList.peek().length() == i){
                String it = resultList.remove();
                for (char c: chArray) {
                    resultList.add(it + c);
                }
            }
        }
        return resultList;
    }
}
