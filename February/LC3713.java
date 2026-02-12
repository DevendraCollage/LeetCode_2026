class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int freq[] = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                if ((j - i + 1) > maxLen && checkBalance(freq)) {
                    maxLen = j - i + 1;
                }
            }
        }

        return maxLen;
    }

    boolean checkBalance(int freq[]) {
        int except = 0;
        for (int i : freq) {
            if (i == 0) {
                continue;
            }
            if (except == 0) {
                except = i;
            } else if (i != except) {
                return false;
            }
        }

        return true;
    }
}