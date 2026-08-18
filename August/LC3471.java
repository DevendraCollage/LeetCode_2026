class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] count = new int[51];

        for (int i = 0; i <= nums.length - k; i++) {
            boolean[] seen = new boolean[51];

            for (int j = i; j < i + k; j++) {
                seen[nums[j]] = true;
            }

            for (int j = 0; j <= 50; j++) {
                if (seen[j]) {
                    count[j]++;
                }
            }
        }

        for (int i = 50; i >= 0; i--) {
            if (count[i] == 1) {
                return i;
            }
        }

        return -1;
    }
}