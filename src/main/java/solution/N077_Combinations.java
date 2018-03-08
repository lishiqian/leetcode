package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 *
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */

/**
 * 题目大意：
 * 求一个数组的组合
 */
public class N077_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<Integer> recodeList = new ArrayList<Integer>();
        combine(1,n,k,resultList,recodeList);
        return resultList;
    }

    public void combine(int value,int n,int k,List<List<Integer>> resultList,List<Integer> recodeList){
        if(recodeList.size() == k){
            resultList.add(new ArrayList<>(recodeList));
            return;
        }
        if(value > n) return;

        recodeList.add(value);
        combine(value + 1,n,k,resultList,recodeList);
        recodeList.remove(recodeList.size() - 1);
        combine(value + 1,n,k,resultList,recodeList);
    }
}
