class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;

        boolean[] one = new boolean[MAX];
        boolean[] two = new boolean[MAX];
        boolean[] three = new boolean[MAX];

        for (int x : nums) {
            one[x] = true;
        }

        for (int x : nums) {
            boolean[] next = two.clone();
            for (int i = 0; i < MAX; i++) {
                if (one[i]) {
                    next[i ^ x] = true;
                }
            }
            two = next;
        }

        for (int x : nums) {
            boolean[] next = three.clone();
            for (int i = 0; i < MAX; i++) {
                if (two[i]) {
                    next[i ^ x] = true;
                }
            }
            three = next;
        }

        int ans = 0;
        for (boolean b : three) {
            if (b) {
                ans++;
            }
        }

        return ans;
    }
}