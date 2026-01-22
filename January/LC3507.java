import java.util.ArrayList;
import java.util.List;

class Solution {

    public int minimumPairRemoval(int[] nums) {
        int count = 0; // number of operations

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        while (!checkOrder(list)) {
            int minIndex = -1;
            int minSum = Integer.MAX_VALUE;

            for (int i = 1; i < list.size(); i++) {
                int adjSum = list.get(i) + list.get(i - 1);
                if (adjSum < minSum) {
                    minSum = adjSum;
                    minIndex = i - 1;
                }
            }

            // Merge the pair
            if (minIndex != -1) {
                list.remove(minIndex + 1);
                list.set(minIndex, minSum);
                count++;
            }
        }

        return count;
    }

    // Checks if the list is in non-decreasing order
    boolean checkOrder(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
