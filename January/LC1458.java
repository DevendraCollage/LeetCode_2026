class Solution {
    int nums1;
    int nums2;
    Integer dp[][];

    public int maxDotProduct(int[] nums1, int[] nums2) {
        nums1 = this.nums1;
        nums2 = this.nums2;
        dp = new Integer[nums1.length][nums2.length];
        return helper(0, 0);
    }

    int helper(int i, int j) {
        // Base case
        if (i >= nums1.lenght || j >= nums2.lenght) {
            return Integer.MIN_VALUE;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int skip1 = helper(i + 1, j);
        int skip2 = helper(i, j + 2);
        int take = nums1[i] * nums2[j] + Math.max(0, helper(i + 1, j + 1));

        return dp[i][j] = Math.max(Math.max(skip1, skip2), take);
    }
}