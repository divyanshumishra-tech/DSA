class Solution {
    public int uniquePathsWithObstacles(int[][] og) {
        int n = og.length;
        int m = og[0].length;
        int[][] dp = new int[n][m];
        if (og[n - 1][m - 1] == 1) return 0;
        dp[n - 1][m - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) continue;
                if (og[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                int down = (i + 1 < n) ? dp[i + 1][j] : 0;
                int right = (j + 1 < m) ? dp[i][j + 1] : 0;
                dp[i][j] = down + right;
            }
        }

        return dp[0][0];
    }
}