import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : invocations) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] isSuspicious = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(k);
        isSuspicious[k] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();

            for (int next : adj.get(current)) {
                if (!isSuspicious[next]) {
                    isSuspicious[next] = true;
                    stack.push(next);
                }
            }
        }

        for (int[] edge : invocations) {
            int caller = edge[0];
            int called = edge[1];

            if (!isSuspicious[caller] && isSuspicious[called]) {
                List<Integer> all = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    all.add(i);
                }
                return all;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!isSuspicious[i]) {
                result.add(i);
            }
        }

        return result;
    }
}