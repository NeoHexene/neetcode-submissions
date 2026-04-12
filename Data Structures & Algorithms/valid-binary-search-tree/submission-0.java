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
    public boolean isValidBST(TreeNode root) {
        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{root, Integer.MIN_VALUE, Integer.MAX_VALUE});

        while (!q.isEmpty()) {
            Object[] curr = q.poll();
            TreeNode node = (TreeNode) curr[0];
            int low = (int) curr[1], high = (int) curr[2];

            if (node.val <= low || node.val >= high) {
                return false;
            }

            if (node.left != null) {
                q.offer(new Object[]{node.left, low, node.val});
            }

            if (node.right != null) {
                q.offer(new Object[]{node.right, node.val, high});
            }
        }

        return true;
    }
}
