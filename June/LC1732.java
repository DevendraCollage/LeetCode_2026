class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int curr = 0;

        for (int i : gain) {
            curr += i;
            max = Math.max(curr, max);
        }

        return max;
    }
}