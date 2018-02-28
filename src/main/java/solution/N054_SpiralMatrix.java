package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * For example,
 * Given the following matrix:
 *
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */

/**
 * 题目大意：
 * 顺时针打印数组
 */
public class N054_SpiralMatrix {
    //顺时针打印矩阵
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resList = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return resList;
        int start = 0;
        int height = matrix.length;
        int width = matrix[0].length;

        while (height > 0 && width > 0){
            spiralOrder(matrix,start,width,height,resList);
            start++;
            height-=2;
            width-=2;
        }
        return resList;
    }

    public void spiralOrder(int[][] matrix,int start,int width,int height,List<Integer> resList){
        for (int i = start; i < start + width; i++) {
            resList.add(matrix[start][i]);
        }

        for (int i = start + 1; i < start + height - 1; i++) {
            resList.add(matrix[i][start + width - 1]);
        }

        if(height > 1){
            for (int i = start + width - 1; i >= start; i--) {
                resList.add(matrix[start + height - 1][i]);
            }
        }

        if(width > 1){
            for (int i = start + height - 2; i > start; i--) {
                resList.add(matrix[i][start]);
            }
        }
    }

    @Test
    public void tese(){
        int[][] matrix = new int[4][];
        matrix[0] = new int[]{1,2,3,4};
        matrix[1] = new int[]{5,6,7,8};
        matrix[2] = new int[]{9,10,11,12};
        matrix[3] = new int[]{13,14,15,16};

        List<Integer> resList = spiralOrder(matrix);
        System.out.println(resList);
    }
}
