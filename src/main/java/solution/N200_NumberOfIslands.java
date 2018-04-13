package solution;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 *
 * Example 2:
 *
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 */
public class N200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;

        int result = 0;
        boolean[][] visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visit[i][j]){
                    dfs(grid,m,n,i,j,visit);
                    result++;
                }
            }
        }

        return result;
    }

    public void dfs(char[][] grid,int m,int n,int i,int j,boolean[][] visit){
        if(i < 0 || i >= m || j < 0 || j >= n || visit[i][j] || grid[i][j] != '1')
            return;

        visit[i][j] = true;
        dfs(grid,m,n,i+1,j,visit);
        dfs(grid,m,n,i-1,j,visit);
        dfs(grid,m,n,i,j+1,visit);
        dfs(grid,m,n,i,j-1,visit);
    }
}
