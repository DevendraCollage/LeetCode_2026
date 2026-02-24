public class LC1022 {
    int val;
    TreeNode left;
    TreeNode right;

    LC1022() {
    }

    LC1022(int val) {
        this.val = val;
    }

    LC1022(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, "");
    }

    private int helper(TreeNode root, String num) {
        if (root == null) {
            return 0;
        }
        num = num + root.val;
        if (root.right == null && root.left == null) {
            return Integer.parseInt(num, 2);
        }
        return helper(root.left, num) + helper(root.right, num);
    }
}