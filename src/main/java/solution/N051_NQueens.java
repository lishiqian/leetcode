package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * he n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 *
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */

/**
 * 题目问题:
 * N皇后
 */
public class N051_NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '.';
            }
        }

        List<List<String>> resList = new ArrayList<List<String>>();;

        solve(matrix,0,resList);
        return resList;
    }

    public void solve(char[][] matrix,int col,List<List<String>> resList){
        if(col == matrix.length){
            List<String> solution = new ArrayList<String>(matrix.length);
            for (int i = 0; i < matrix.length; i++) {
                solution.add(new String(matrix[i]));
            }
            resList.add(solution);
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            if(check(matrix,i,col)){
                matrix[i][col] = 'Q';
                solve(matrix,col + 1,resList);
                matrix[i][col] = '.';
            }
        }
    }

    public boolean check(char[][] matrix,int row,int col){
        //行检测
        for (int i = 0; i < col; i++) {
            if(matrix[row][i] == 'Q') return false;
        }

        //对角线检测
        for (int i = row - 1,j = col - 1; i >= 0 && j >= 0; i--,j--) {
            if(matrix[i][j] == 'Q') return false;
        }

        for (int i = row + 1,j = col - 1; i < matrix.length && j >= 0; i++,j--) {
            if(matrix[i][j] == 'Q') return false;
        }

        return true;
    }

    @Test
    public void test(){
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);
    }
}
