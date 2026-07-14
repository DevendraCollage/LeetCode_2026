import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        int minlen = String.valueOf(low).length();
        int maxlen = String.valueOf(high).length();

        List<Integer> ans = new ArrayList<>();
        for (int i = minlen; i <= maxlen; i++) {
            for (int j = 0; j + i <= 9; j++) {
                String substr = s.substring(j, j + i);
                int num = Integer.parseInt(substr);
                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        return ans;
    }
}