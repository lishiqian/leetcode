package solution;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */

import java.util.HashSet;
import java.util.Iterator;

/**
 * 题目大意：
 * 给你一个矩阵，把其中包含0的元素的行和列变成0
 */
public class N073_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rowSet = new HashSet<Integer>();
        HashSet<Integer> colSet = new HashSet<Integer>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }


        Iterator<Integer> colIt = colSet.iterator();
        while (colIt.hasNext()){
            int col = colIt.next();
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }

        Iterator<Integer> rowIt = rowSet.iterator();
        while (rowIt.hasNext()){
            int row = rowIt.next();
            for (int i = 0; i < matrix[row].length; i++) {
                matrix[row][i] = 0;
            }
        }
    }
}
