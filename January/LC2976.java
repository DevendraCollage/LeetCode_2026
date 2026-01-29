import java.util.Arrays;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long ans = 0;
        final long INF = Long.MAX_VALUE / 2;

        long mincost[][] = new long[26][26];

        for (long[] c : mincost) {
            Arrays.fill(c, Integer.MAX_VALUE);
        }

        for (int i = 0; i < original.length; i++) {
            int src = original[i] - 'a';
            int dest = changed[i] - 'a';
            mincost[src][dest] = Math.min(mincost[src][dest], cost[i]);
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    if (mincost[j][i] < INF && mincost[i][k] < INF) {
                        mincost[j][k] = Math.min(mincost[j][k],
                                mincost[j][i] + mincost[i][k]);
                    }
                }
            }
        }

        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i) - 'a';
            int d = target.charAt(i) - 'a';
            if (s == d) {
                continue;
            }
            if (mincost[s][d] == Integer.MAX_VALUE) {
                return -1;
            }
            ans += mincost[s][d];
        }

        return ans;
    }
}