package solution;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 *
 * A partially filled sudoku which is valid.
 *
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */

/**
 *  题目大意：
 *  给你一个数独，验证是否合法，数独可能没填满
 */
public class N036_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if(validRow(board,i) && validCol(board,i) && validSudoku(board,i)) continue;
            return false;
        }
        return true;
    }


    public boolean validRow(char[][] board,int rowNum){
       boolean[] flag = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if(board[rowNum][i] != '.'){
                int index = board[rowNum][i] - '1';
                if(flag[index] == true) //rowNum行的数字以存在
                    return false;
                else
                    flag[index] = true;
            }
        }
        return true;
    }

    public boolean validCol(char[][] board,int colNum){
        boolean[] flag = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if(board[i][colNum] != '.'){
                int index = board[i][colNum] - '1';
                if(flag[index] == true) //colNum列的数字已经存在
                    return false;
                else
                    flag[index] = true;
            }
        }
        return true;
    }

    public boolean validSudoku(char[][] board,int sudokuNum){
        boolean[] flag = new boolean[9];

        int row = sudokuNum/3;
        int col = sudokuNum%3;

        for (int i = row*3; i < row*3+3; i++) {
            for (int j = col*3; j < col*3+3; j++) {
                if(board[i][j] != '.'){
                    int index = board[i][j] - '1';
                    if(flag[index] == true) //数字已经存在
                        return false;
                    else
                        flag[index] = true;
                }
            }
        }

        return true;
    }
}
