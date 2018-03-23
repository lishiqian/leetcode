package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3,
 * Return [1,3,3,1].
 *
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class N119_PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            ans.add(1);
            for (int j = i - 1; j > 0; j--) {
                ans.set(j,ans.get(j-1) + ans.get(j));
            }
        }

        return ans;
    }

    @Test
    public void test(){
        System.out.println(getRow(3));
    }
}
