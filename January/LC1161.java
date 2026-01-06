import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class Solution {
    public int maxLevelSum(TreeNode root) {
        int ans = 0;
        int maxVal = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;

        queue.add(root);
        while (!queue.isEmpty()) {
            level++;
            int currSum = 0;
            int size = queue.size();

            for (int i = size; i > 0; i--) {
                TreeNode tn = queue.poll();
                currSum += tn.val;

                if (tn.left != null) {
                    queue.add(tn.left);
                }

                if (tn.right != null) {
                    queue.add(tn.right);
                }
            }

            if (maxVal < currSum) {
                maxVal = currSum;
                ans = level;
            }
        }
        return ans;
    }
}