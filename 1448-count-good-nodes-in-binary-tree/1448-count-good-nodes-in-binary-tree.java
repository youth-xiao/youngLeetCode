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


class Pair {
    TreeNode node;
    int maxSofar;
    
    Pair(TreeNode node, int maxSofar) {
        this.node = node;
        this.maxSofar = maxSofar;
    }
}

class Solution {
    public int goodNodes(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, Integer.MIN_VALUE));
        int good = 0;
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            TreeNode n = p.node;
            int currMax = p.maxSofar;
            
            if (n.val >= currMax) {
                good++;
            }
            if (n.left != null) {
                stack.push(new Pair(n.left, Math.max(currMax, n.val)));
            }
            if (n.right != null) {
                stack.push(new Pair(n.right, Math.max(currMax, n.val)));
            }
        }
        return good;
    }
}


// class Solution {
    
//     private int good = 0;
    
//     public int goodNodes(TreeNode root) {
//         dfs(root, Integer.MIN_VALUE);
//         return good;
//     }
    
//     private void dfs(TreeNode node, int maxSoFar) {
//         if (node.val >= maxSoFar) {
//             good++;
//         }
//         if (node.left != null) {
//             dfs(node.left, Math.max(maxSoFar, node.val));
//         }
//         if (node.right != null) {
//             dfs(node.right, Math.max(maxSoFar, node.val));
//         }
        
//     }
// }