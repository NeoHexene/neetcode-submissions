/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root, 1);
    }

    private int dfs (TreeNode root, int level) {
        if (root == null) return level - 1;

        int leftLevel = dfs(root.left, level + 1);
        int rightLevel = dfs(root.right, level + 1);

        return Math.max(leftLevel, rightLevel);
    }
}
