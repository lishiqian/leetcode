package solution;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * For example,
 * Given board =
 *
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */

/**
 * 题目大意：
 * 在一个二位数组中查找一个字符串
 * 这个词可以由相邻细胞的字母构成，
 * “相邻”细胞是水平或垂直相邻的细胞。
 * 同一个字母的单元格可能不会被重复使用一次。
 */
public class N079_WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] unused = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0) && find(board,word,0,i,j,m,n,unused))
                    return true;
            }
        }
        return false;
    }

    public boolean find(char[][] board, String word,int index,int i,int j,int m,int n,boolean[][] unused){
        if(index == word.length()) return true;
        if(i < 0 || i >= m || j < 0 || j >= n || unused[i][j] || board[i][j] != word.charAt(index)) return false;

        unused[i][j] = true;
        if(find(board,word,index + 1,i-1,j,m,n,unused)||
           find(board,word,index + 1,i+1,j,m,n,unused)||
           find(board,word,index + 1,i,j-1,m,n,unused)||
           find(board,word,index + 1,i,j+1,m,n,unused)){
            return true;
        }
        unused[i][j] = false;

        return false;
    }
}
