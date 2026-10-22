class Solution {

    private int count = 0;
    private boolean[] cols;
    private boolean[] diag1;
    private boolean[] diag2;
    private int n;

    public int totalNQueens(int n) {
        this.n = n;

        cols = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];

        backtrack(0);

        return count;
    }

    private void backtrack(int row) {

        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {

            int d1 = row - col + n - 1;
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }

            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(row + 1);

            // Backtrack
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}