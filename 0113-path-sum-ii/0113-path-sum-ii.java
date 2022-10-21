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


// with backtrack is MUCH FASTER
class Solution {
    List<List<Integer>> result;
//     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//         result = new ArrayList<>();
//         helper(root, targetSum, new ArrayList<>());
//         return result;
//     }
    
//     private void helper(TreeNode root, int sum, List<Integer> temp) {
//         if (root == null) return;
//         if (root.left == null && root.right == null) { // reach leaf
//             if (root.val == sum) {
//                 temp.add(root.val);
//                 result.add(new ArrayList<>(temp));
//                 temp.remove(temp.size() - 1); // backtrack
//             }
//             return;
//         }
//         temp.add(root.val);
//         helper(root.left, sum - root.val, temp);
//         helper(root.right, sum - root.val, temp);
//         temp.remove(temp.size() - 1);
//     }
    
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>());
        return result;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> temp) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                temp.add(root.val);
                result.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                return;
            }
            
        }
        temp.add(root.val);
        helper(root.left, sum - root.val, temp);
        helper(root.right, sum - root.val, temp);
        temp.remove(temp.size() - 1);
    }
}


// class Solution {
//     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//         List<List<Integer>> result = new ArrayList<>();
//         findPaths(root, targetSum, new ArrayList<Integer>(), result);
//         return result;
//     }
    
//     private void findPaths(TreeNode root, int sum, List<Integer> current, List<List<Integer>> result) {
//         if (root == null) return;
//         current.add(root.val);
//         if (root.val == sum && root.left == null && root.right == null) {
//             result.add(current);
//             return;
//         }
//         findPaths(root.left, sum - root.val, new ArrayList<Integer>(current), result);
//         findPaths(root.right, sum - root.val, new ArrayList<Integer>(current), result);
//     }
// }