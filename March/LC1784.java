class Solution {
    public boolean checkOnesSegment(String s) {
        boolean ans = false;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '0') {
                ans = true;
            } else if (s.charAt(i) == '1' && ans) {
                return false;
            }

        }

        return true;
    }
}