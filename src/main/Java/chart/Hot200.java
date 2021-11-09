package chart;

/**
 * 岛屿数量
 */
public class Hot200 {
    char t = 'a';

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = t;
                    DFS(i, j, grid);
                    t++;
                }
            }
        }
        return t - 'a';
    }

    public void DFS(int i, int j, char[][] grid) {
        if ((j + 1) < grid[i].length && grid[i][j + 1] == '1') {

            grid[i][j + 1] = t;
            DFS(i, j + 1, grid);

        }
        if ((i + 1) < grid.length && grid[i + 1][j] == '1') {

            grid[i + 1][j] = t;
            DFS(i + 1, j, grid);

        }
        if ((j - 1) >= 0 && grid[i][j - 1] == '1') {

            grid[i][j - 1] = t;
            DFS(i, j - 1, grid);

        }
        if ((i - 1) >= 0 && grid[i - 1][j] == '1') {

            grid[i - 1][j] = t;
            DFS(i - 1, j, grid);

        }
    }
}
