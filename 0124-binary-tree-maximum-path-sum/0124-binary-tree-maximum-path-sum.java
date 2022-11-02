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
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left); // left subtree recursion
        int right = helper(root.right); // right subtree recursion
        // currMax: choose from 3 options:
        // 1. root + left-subtree (at least left-subtree is not negative)
        // 2. root + right-subtree (at least right-subtree is not negative)
        // 3. just root (both left and right subtrees have negative sum)
        int currMax = Math.max(root.val, Math.max(left + root.val, right + root.val));
        // actually the 4th option is: root + left-subtree + right-subtree
        // 之所以分行写是因为一行code比较4个选择 不容易看懂
        max = Math.max(max, Math.max(currMax, left + right + root.val));
        return currMax;
    }
}



// // Method without using global variable
// class Solution {
//     public int maxPathSum(TreeNode root) {
//         int[] result = new int[1];
//         result[0] = Integer.MIN_VALUE;
//         helper(root, result);
//         return result[0];
//     }
    
//     private int helper(TreeNode root, int[] result) {
//         if (root == null) return 0;
//         int left = helper(root.left, result);
//         int right = helper(root.right, result);
//         result[0] = Math.max(result[0], left + right + root.val); // compare total max with a subtree (including root, left and right if applicable)
//         int currMax = Math.max(root.val, Math.max(left + root.val, right + root.val)); // decide whether to include left or right descendent, if so which one to choose
//         result[0] = Math.max(result[0], currMax); // if currMax is greater than the result[0] obtained from line 48, then update it, because by excluding the left/right descendent, the max may be greater
//         return currMax;
//     }
// }


// class Solution {
//     int max = Integer.MIN_VALUE;
//     public int maxPathSum(TreeNode root) {
//         helper(root);
//         return max;
//     }
    
//     private int helper(TreeNode root) {
//         if (root == null) return 0;
//         int left = Math.max(0, helper(root.left));
//         int right = Math.max(0, helper(root.right));
//         max = Math.max(max, root.val + left + right);
//         return root.val + Math.max(left, right);
//     }
// }