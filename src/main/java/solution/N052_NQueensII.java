package solution;

import org.junit.Test;

/**
 * Follow up for N-Queens problem.
 *
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class N052_NQueensII {
    public int totalNQueens(int n) {
        return solveNQueens(n);
    }


    public int solveNQueens(int n) {
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '.';
            }
        }

        int[] count = new int[1];

        solve(matrix,0,count);
        return count[0];
    }

    public void solve(char[][] matrix,int col,int[] count){
        if(col == matrix.length){
            count[0]++;
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            if(check(matrix,i,col)){
                matrix[i][col] = 'Q';
                solve(matrix,col + 1,count);
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
        System.out.println(solveNQueens(1));
    }

}
