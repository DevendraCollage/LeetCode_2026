class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = n + 1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                int dist1 = Math.abs(startIndex - i);
                int dist2 = n - dist1;
                ans = Math.min(ans, Math.min(dist1, dist2));
            }
        }

        if (ans > n) {
            return -1;
        }
        return ans;
    }
}