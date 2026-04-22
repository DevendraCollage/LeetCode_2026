import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();

        for (String query : queries) {
            for (String word : dictionary) {
                if (checkEquality(query, word)) {
                    ans.add(query);
                    break;
                }
            }
        }

        return ans;
    }

    boolean checkEquality(String s1, String s2) {
        int count = 0;
        int n = s1.length(), i = 0;

        while (i < n && count < 3) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            i++;
        }

        return count < 3;
    }
}