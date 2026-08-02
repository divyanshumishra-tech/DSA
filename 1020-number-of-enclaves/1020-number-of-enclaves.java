class Solution {

    public int numEnclaves(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        // First and last column
        for (int i = 0; i < rows; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, cols - 1);
        }

        // First and last row
        for (int j = 0; j < cols; j++) {
            dfs(grid, 0, j);
            dfs(grid, rows - 1, j);
        }

        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int row, int col) {

        if (row < 0 || col < 0 ||
            row >= grid.length ||
            col >= grid[0].length ||
            grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0;

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}