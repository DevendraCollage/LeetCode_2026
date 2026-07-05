import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        long dp[][] = new long[n][n];
        long cnt[][] = new long[n][n];

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        dp[n - 1][n - 1] = 0;
        cnt[n - 1][n - 1] = 1;

        int dirs[][] = { { 1, 0 }, { 0, 1 }, { 1, 1 } };

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                char c = board.get(i).charAt(j);

                if (c == 'S') {
                    continue;
                }
                if (c == 'X') {
                    continue;
                }

                long best = -1;
                long ways = 0;

                for (int[] d : dirs) {
                    int pi = i + d[0], pj = j + d[1];
                    if (pi >= n || pj >= n) {
                        continue;
                    }
                    if (dp[pi][pj] == -1) {
                        continue;
                    }
                    if (dp[pi][pj] > best) {
                        best = dp[pi][pj];
                        ways = cnt[pi][pj];
                    } else if (dp[pi][pj] == best) {
                        ways = (ways + cnt[pi][pj]) % MOD;
                    }
                }

                if (best == -1) {
                    continue;
                }

                int val = (c == 'E') ? 0 : (c - '0');
                dp[i][j] = best + val;
                cnt[i][j] = ways;
            }
        }

        if (dp[0][0] == -1) {
            return new int[] { 0, 0 };
        }
        return new int[] { (int) dp[0][0], (int) cnt[0][0] };
    }
}