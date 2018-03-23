package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * For example, given numRows = 5,
 * Return
 *
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class N118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i);
            for (int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i) row.add(1);
                else{
                    row.add(ans.get(i - 1).get(j-1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(row);
        }

        return ans;
    }

    @Test
    public void test(){
        generate(3);
    }
}
