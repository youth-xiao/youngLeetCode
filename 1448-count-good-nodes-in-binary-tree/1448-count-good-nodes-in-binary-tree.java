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
    
    private int good = 0;
    
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return good;
    }
    
    private void dfs(TreeNode node, int maxSoFar) {
        if (node.val >= maxSoFar) {
            good++;
        }
        if (node.left != null) {
            dfs(node.left, Math.max(maxSoFar, node.val));
        }
        if (node.right != null) {
            dfs(node.right, Math.max(maxSoFar, node.val));
        }
        
    }
}