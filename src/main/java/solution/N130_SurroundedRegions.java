package solution;

import org.junit.Test;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class N130_SurroundedRegions {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if(board[i][0] == 'O'){
                dfs(board,i,0);
            }
            if(board[i][n-1] == 'O'){
                dfs(board,i,n-1);
            }
        }

        for (int j = 0; j < n; j++) {
            if(board[0][j] == 'O'){
                dfs(board,0,j);
            }

            if(board[m-1][j] == 'O'){
                dfs(board,m-1,j);
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board,int x,int y){
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O') return;
        board[x][y] = '*';

        dfs(board,x-1,y);
        dfs(board,x+1,y);
        dfs(board,x,y-1);
        dfs(board,x,y+1);
    }


    @Test
    public void test(){
        char[][] board = new char[][]{
                new char[]{'X','X','X','X'},
                new char[]{'X','O','O','X'},
                new char[]{'X','X','O','X'},
                new char[]{'X','O','X','X'}
        };

        solve(board);
    }
}
