class Solution {
    public int minFlips(String s) {
        String str = s + s;
        int n = s.length();
        int ans = Integer.MAX_VALUE;

        int onestart = 0, zerostart = 0;

        for (int j = 0; j < 2 * n; j++) {
            char ch = str.charAt(j);
            if (j % 2 == 0) {
                if (ch == '0') {
                    onestart++;
                } else {
                    zerostart++;
                }
            } else {
                if (ch == '0') {
                    zerostart++;
                } else {
                    onestart++;
                }
            }

            if (j >= n - 1) {
                ans = Math.min(ans, Math.min(zerostart, onestart));
                int prev = j - n + 1;
                char pch = str.charAt(prev);
                if (prev % 2 == 0) {
                    if (pch == '0') {
                        onestart--;
                    } else {
                        zerostart--;
                    }
                } else {
                    if (pch == '0') {
                        zerostart--;
                    } else {
                        onestart--;
                    }
                }
            }
        }

        return ans;
    }
}