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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode rightNode = null;
            int size = q.size();
            for (int i = size; i > 0; i--) {
                TreeNode curr = q.poll();
                if (curr == null) {
                    continue;
                }
                rightNode = curr;
                q.offer(curr.left);
                q.offer(curr.right);
            }
            if (rightNode != null) {
                res.add(rightNode.val);
            }
        }
        return res;
    }
}
