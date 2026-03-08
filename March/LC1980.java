import java.util.HashSet;

class Solution {
    static StringBuilder res;

    public static String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<String> set = new HashSet<>();
        for (String num : nums) {
            set.add(num);
        }
        res = new StringBuilder("");
        backTrack(nums, n, set, res);
        return res.toString();
    }

    public static boolean backTrack(String[] nums, int n, HashSet<String> set, StringBuilder res) {
        // base case
        if (res.length() == n) {
            if (!set.contains(res.toString())) {
                return true;
            }
            return false;
        }
        for (char ch = '0'; ch <= '1'; ch++) {
            res.append(ch);
            if (backTrack(nums, n, set, res)) {
                return true;
            }
            res.deleteCharAt(res.length() - 1);
        }
        return false;

    }
}