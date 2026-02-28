class Solution {
    private static final int MOD = 1_000_000_007;

    public int concatenatedBinary(int n) {
        long result = 0;
        int bitLength = 0;
        for (int i = 1; i <= n; i++) {
            bitLength = Integer.toBinaryString(i).length();
            result = ((result << bitLength) + i) % MOD;
        }

        return (int) result;
    }
}