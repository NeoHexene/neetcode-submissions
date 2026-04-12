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
    public int goodNodes(TreeNode root) {
       int res = 0;
       Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
       q.offer(new Pair<>(root, root.val));
       
       while(!q.isEmpty()) {
            Pair<TreeNode, Integer> curr = q.poll();
            TreeNode node = curr.getKey();
            int maxVal = curr.getValue();

            if (node.val >= maxVal) {
                res++;
            }

            if (node.left != null) {
                q.offer(new Pair<>(node.left, Math.max(maxVal, node.val)));
            }
            if (node.right != null) {
                q.offer(new Pair<>(node.right, Math.max(maxVal, node.val)));
            }
       }
       return res;
    }
}
