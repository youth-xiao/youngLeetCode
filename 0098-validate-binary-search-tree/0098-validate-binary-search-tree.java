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


// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         Stack<TreeNode> stack = new Stack<>();
//         while (root != null) {
//             stack.push(root);
//             root = root.left;
//         }
        
//         TreeNode lastNode = null;
//         while (!stack.isEmpty()) {
//             TreeNode node = stack.peek();
//             if (lastNode != null && lastNode.val >= node.val) {
//                 return false;
//             }
//             lastNode = node;
            
//             if (node.right == null) {
//                 node = stack.pop();
//                 while (!stack.isEmpty() && stack.peek().right == node) {
//                     node = stack.pop();
//                 }
//             }
//             else {
//                 node = node.right;
//                 while (node != null) {
//                     stack.push(node);
//                     node = node.left; // 这里又是遍历左子树
//                 }
//             }
//         }
//         return true;
//     }
// }


// https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if (root == null) return true;
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode prev = null;
//         while (root != null || !stack.isEmpty()) {
//             while (root != null) {
//                 stack.push(root);
//                 root = root.left;
//             }
//             root = stack.pop();
//             if (prev != null && root.val <= prev.val) {
//                 return false;
//             }
//             prev = root;
//             root = root.right;
//         }
//         return true;
//     }
// }


// FASTEST
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}