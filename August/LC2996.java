import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }

        int sequential = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sequential += nums[i];
            } else {
                break;
            }
        }

        while (st.contains(sequential)) {
            sequential++;
        }

        return sequential;
    }
}