class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ones = 0, maxsum = 0, prevsum = -1;
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '1') {
                ones++;
                i++;
            } else {
                int curr = 0;
                while (i < n && s.charAt(i) == '0') {
                    curr++;
                    i++;
                }

                if (prevsum > 0) {
                    maxsum = Math.max(maxsum, prevsum + curr);
                }
                prevsum = curr;
            }
        }

        return ones + maxsum;
    }
}