import java.util.HashSet;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> hset = new HashSet<>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            hset.add(s.substring(i, i + k));
        }
        if (hset.size() == Math.pow(2, k)) {
            return true;
        } else {
            return false;
        }
    }
}