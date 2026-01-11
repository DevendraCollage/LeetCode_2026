import javax.swing.tree.TreeNode;

class Result {
    TreeNode node;
    int depth;

    Result(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        TreeNode result = helper(root).node;
        return result;
    }

    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(null, 0);
            Result left = helper(root.left);
            Result right = helper(root.right);
            if (left.depth == right.depth) {
                return new Result(root, left.depth + 1);
            } else if (left.depth > right.depth) {
                return new Result(left.node, left.depth + 1);
            } else {
                return new Result(right.node, right.depth + 1);
            }
        }
    }
}