class Solution {
    static String result;
    static int count;

    public static String getHappyString(int n, int k) {
        count = 0;
        result = "";
        backTrack(n, k, new StringBuilder(""));
        return result;
    }

    public static boolean backTrack(int n, int k, StringBuilder cur) {
        // base case
        if (cur.length() == n) {
            count++;
            if (count == k) {
                result = cur.toString();
                return true;
            }
            return false;
        }
        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (cur.length() > 0 && cur.charAt(cur.length() - 1) == ch) {
                continue;
            }
            cur.append(ch);
            if (backTrack(n, k, cur)) {
                return true;
            }
            cur.deleteCharAt(cur.length() - 1);
        }

        return false;
    }
}