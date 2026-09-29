class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        if (((m + n - 1) & 1) == 1)
            return false;
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
            return false;

        int maxBal = (m + n - 1) / 2;
        boolean[][] dp = new boolean[n][maxBal + 2];
        dp[0][1] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;

                boolean[] next = new boolean[maxBal + 2];
                boolean[] top = dp[j];
                boolean[] left = j > 0 ? dp[j - 1] : null;

                for (int b = 0; b <= maxBal; b++) {
                    boolean reach = top[b] || (left != null && left[b]);
                    if (!reach)
                        continue;

                    if (grid[i][j] == '(') {
                        if (b + 1 <= maxBal)
                            next[b + 1] = true;
                    } else {
                        if (b - 1 >= 0)
                            next[b - 1] = true;
                    }
                }
                dp[j] = next;
            }
        }

        return dp[n - 1][0];
    }
}