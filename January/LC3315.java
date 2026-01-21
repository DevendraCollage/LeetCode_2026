import java.util.List;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int ans[] = new int[n];

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            if (num % 2 == 0) {
                ans[i] = -1;
                continue;
            }

            int bit = 1;
            int curr = 0;
            int num2 = nums.get(i);

            while ((num2 & bit) > 0) {
                curr = (num2 & (~bit));
                bit = bit << 1;
            }

            ans[i] = curr;
        }

        return ans;
    }
}