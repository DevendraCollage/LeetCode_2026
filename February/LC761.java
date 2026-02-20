import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String makeLargestSpecial(String s) {
        List<String> specials = new ArrayList<>();
        int count = 0; // tracks balance (1s - 0s)
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                count++;
            else
                count--;

            if (count == 0) {
                String inner = makeLargestSpecial(s.substring(start + 1, i));
                specials.add("1" + inner + "0");
                start = i + 1;
            }
        }

        specials.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String sp : specials)
            sb.append(sp);
        return sb.toString();
    }
}