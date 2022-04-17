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
    int total;
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        total = 0;
        dfs(root, low, high);
        return total;
    }
    
    private void dfs(TreeNode node, int lo, int hi) {
        if (node != null) {
            if (node.val >= lo && node.val <= hi) {
                total += node.val;
            }
            if (node.val > lo) {
                dfs(node.left, lo, hi);
            }
            if (node.val < hi) {
                dfs(node.right, lo, hi);
            }
        }
    }
}