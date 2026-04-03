class Solution {
    int m, n;
    Integer dp[][][];

    public int maximumAmount(int[][] coins) {
        this.m = coins.length;
        this.n = coins[0].length;

        dp = new Integer[m][n][3];

        return helper(coins, 0, 0, 2);
    }

    int helper(int[][] coins, int i, int j, int skips) {
        if (i >= m || j >= n)
            return Integer.MIN_VALUE;

        if (dp[i][j][skips] != null)
            return dp[i][j][skips];

        if (i == m - 1 && j == n - 1) {
            if (coins[i][j] < 0 && skips > 0)
                return 0;
            return coins[i][j];
        }

        int right = helper(coins, i, j + 1, skips);
        int down = helper(coins, i + 1, j, skips);
        int skip = Integer.MIN_VALUE;

        if (coins[i][j] < 0 && skips > 0) {
            int downskip = helper(coins, i + 1, j, skips - 1);
            int rightskip = helper(coins, i, j + 1, skips - 1);
            skip = Math.max(downskip, rightskip);
        }

        int maxcoins = Math.max(Math.max(down, right) + coins[i][j],
                skip);

        return dp[i][j][skips] = maxcoins;
    }
}