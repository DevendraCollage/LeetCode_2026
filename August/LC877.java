class Solution {
    public boolean stoneGame(int[] piles) {
        final int n = piles.length;
        int[] dp = piles.clone();

        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j - i >= 0; j--) {
                final int d = j - i;
                dp[j] = Math.max(piles[d] - dp[j], piles[j] - dp[j - 1]);
            }
        }

        return dp[n - 1] > 0;
    }
}