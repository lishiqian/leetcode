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
//    public void setZeroes(int[][] matrix) {
//        HashSet<Integer> rowSet = new HashSet<Integer>();
//        HashSet<Integer> colSet = new HashSet<Integer>();
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if(matrix[i][j] == 0){
//                    rowSet.add(i);
//                    colSet.add(j);
//                }
//            }
//        }
//
//
//        Iterator<Integer> colIt = colSet.iterator();
//        while (colIt.hasNext()){
//            int col = colIt.next();
//            for (int i = 0; i < matrix.length; i++) {
//                matrix[i][col] = 0;
//            }
//        }
//
//        Iterator<Integer> rowIt = rowSet.iterator();
//        while (rowIt.hasNext()){
//            int row = rowIt.next();
//            for (int i = 0; i < matrix[row].length; i++) {
//                matrix[row][i] = 0;
//            }
//        }
//    }


    //O(1)空间复杂度解放
    public void setZeroes(int[][] matrix) {
        boolean firstRowExistZero = false;  
        boolean firstColExistZero = false;
        
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if(matrix[0][i] == 0){
                firstRowExistZero = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if(matrix[i][0] == 0){
                firstColExistZero = true;
                break;
            }
        }



        for (int i = 1; i < m; i++) {
            for (int j = 4; j < n; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if(matrix[i][0] == 0)
                fullRowZero(matrix,i,m,n);
        }

        for (int j = 1; j < n; j++) {
            if(matrix[0][j] == 0)
                fullColZero(matrix,j,m,n);
        }

        if(firstRowExistZero){
            fullRowZero(matrix,0,m,n);
        }

        if(firstColExistZero){
            fullColZero(matrix,0,m,n);
        }
    }
    
    public void fullRowZero(int[][] matrix,int i,int m,int n){
        for (int j = 0; j < n; j++) {
            matrix[i][j] = 0;
        }
    }

    public void fullColZero(int[][] matrix,int j,int m,int n){
        for (int i = 0; i < m; i++) {
            matrix[i][j] = 0;
        }
    }
}
