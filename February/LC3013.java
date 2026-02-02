import java.util.TreeSet;
import java.util.Comparator;

class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        // Comparator: sort by value, then index
        Comparator<Integer> cmp = (a, b) -> {
            if (nums[a] != nums[b])
                return Integer.compare(nums[a], nums[b]);
            return Integer.compare(a, b);
        };

        TreeSet<Integer> currSet = new TreeSet<>(cmp);
        TreeSet<Integer> futSet = new TreeSet<>(cmp);

        long currSum = 0;
        long ans = Long.MAX_VALUE;

        for (int i = 1; i <= dist + 1; i++) {
            currSet.add(i);
            currSum += nums[i];
        }

        while (currSet.size() > k - 1) {
            int idx = currSet.pollLast();
            currSum -= nums[idx];
            futSet.add(idx);
        }

        ans = currSum;

        // Slide the window
        for (int left = 1; left + dist + 1 < n; left++) {
            int right = left + dist + 1;

            if (currSet.contains(left)) {
                currSum -= nums[left];
                currSet.remove(left);
            } else {
                futSet.remove(left);
            }

            futSet.add(right);

            while (currSet.size() < k - 1 && !futSet.isEmpty()) {
                int idx = futSet.pollFirst();
                currSet.add(idx);
                currSum += nums[idx];
            }

            if (!currSet.isEmpty() && !futSet.isEmpty()) {
                int maxC = currSet.last();
                int minF = futSet.first();

                if (nums[minF] < nums[maxC]) {
                    currSet.remove(maxC);
                    futSet.remove(minF);

                    currSum -= nums[maxC];
                    currSum += nums[minF];

                    currSet.add(minF);
                    futSet.add(maxC);
                }
            }

            ans = Math.min(ans, currSum);
        }

        return ans + nums[0];
    }
}
