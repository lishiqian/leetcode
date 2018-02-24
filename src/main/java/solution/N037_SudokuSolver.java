package solution;

import org.junit.Test;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * Empty cells are indicated by the character '.'.
 *
 * You may assume that there will be only one unique solution.
 *
 *
 * A sudoku puzzle...
 *
 *
 * ...and its solution numbers marked in red.
 */

/**
 * 题目大意：
 * 给你一个数独题目，编程解决它
 */
public class N037_SudokuSolver {
    public boolean endFlag = false;

    public void solveSudoku(char[][] board) {
        endFlag = false;
        backtrack(board,0,0);
    }

    public void backtrack(char[][] board,int row,int col){
        if(endFlag) return;
        if(col == 9){
            col = 0;
            row++;
        }
        if(row == 9 && col == 0){
            endFlag = true;
            return;
        }

        if(board[row][col] == '.') {
            for (int i = 1; i <= 9; i++) {
                char c = (char)('0' + i);
                if (valid(board, row, col,c)){
                    board[row][col] = c;
                    backtrack(board,row,col+1);
                    if(!endFlag) board[row][col] = '.';
                }
            }
        }else{
            backtrack(board,row,col+1);
        }
    }


    public boolean valid(char[][] board,int row,int col,char c){
        for (int i = 0; i < 9; i++) {
            if(board[row][i] == c) return false;
            if(board[i][col] == c) return false;
        }

        int startRow = row/3;
        int startCol = col/3;
        for (int i = startRow * 3; i < startRow * 3 + 3; i++) {
            for (int j = startCol * 3; j < startCol * 3 + 3; j++) {
                if(board[i][j] == c) return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = '.';
            }
        }

        solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.printf(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
