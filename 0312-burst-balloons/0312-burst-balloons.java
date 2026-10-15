class Solution {
    public int maxCoins(int[] nums) {

        int n = nums.length;

        int[] a = new int[n + 2];
        a[0] = 1;
        a[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            a[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        // Process intervals from smaller to larger
        for (int len = 2; len <= n + 1; len++) {

            for (int left = 0;
                 left + len <= n + 1;
                 left++) {

                int right = left + len;

                for (int i = left + 1; i < right; i++) {

                    int coins =
                        dp[left][i]
                        + dp[i][right]
                        + a[left] * a[i] * a[right];

                    dp[left][right] =
                        Math.max(dp[left][right], coins);
                }
            }
        }

        return dp[0][n + 1];
    }
}