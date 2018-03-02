package solution;

import org.junit.Test;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * For example,
 * Given n = 3,
 *
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class N059_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int beginRow = 0,beginCol = 0;
        int endRow = n - 1,endCol = n - 1;

        int num = 1;
        while (beginRow <= endRow && beginCol <= endCol){
            for (int i = beginCol; i <= endCol; i++) {
                matrix[beginRow][i] = num++;
            }
            beginRow++;

            for (int i = beginRow; i <= endRow; i++) {
                matrix[i][endCol] = num++;
            }
            endCol--;

            if(beginCol <= endCol){
                for (int i = endCol; i >= beginCol; i--) {
                    matrix[endRow][i] = num++;
                }
            }
            endRow--;

            if(beginRow <= endRow){
                for (int i = endRow; i >= beginRow; i--) {
                    matrix[i][beginCol] = num++;
                }
            }
            beginCol++;
        }

        return matrix;
    }

    @Test
    public void test(){
        System.out.println(generateMatrix(4));
    }
}
