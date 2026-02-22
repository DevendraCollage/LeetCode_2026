class Solution {
    public int binaryGap(int n) {
        int max = 0;
        int prev = -1;
        for (int index = 0; index < 32; index++) {
            if ((n & 1) > 0) {
                if (prev == 1) {
                    prev = index;
                } else {
                    max = Math.max(index - prev, max);
                    prev = index;
                }
            }

            n = n >> 1;
        }

        return max;
    }
}