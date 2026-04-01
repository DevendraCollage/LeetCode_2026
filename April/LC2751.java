import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            indices.add(i);
        }
        Collections.sort(indices, (a, b) -> positions[a] - positions[b]);

        Stack<Integer> st = new Stack<>();
        for (int i : indices) {
            if (directions.charAt(i) == 'R') {
                st.push(i);
                continue;
            }

            while (!st.isEmpty() && healths[i] > 0) {
                int htop = st.peek();

                if (healths[htop] > healths[i]) {
                    healths[st.peek()] -= 1;
                    healths[i] = 0;
                } else if (healths[htop] < healths[i]) {
                    int pos = st.pop();
                    healths[pos] = 0;
                    healths[i] -= 1;
                } else {
                    healths[st.pop()] = 0;
                    healths[i] = 0;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int remainingHealth : healths) {
            if (remainingHealth > 0)
                ans.add(remainingHealth);
        }

        return ans;
    }
}