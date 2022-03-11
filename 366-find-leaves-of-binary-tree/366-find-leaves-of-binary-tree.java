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
    
    private List<Pair<Integer, Integer>> pairs;
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        this.pairs = new ArrayList<>();
        getHeight(root); // this line will keep going until reaching the root and exit
        // sort the key (height) of pair
        Collections.sort(this.pairs, Comparator.comparing(p -> p.getKey())); 
        int size = this.pairs.size();
        int height = 0;
        int count = 0;
        
        List<List<Integer>> output = new ArrayList<>();
        while (count < size) {
            List<Integer> nums = new ArrayList<>();
            while (count < size && this.pairs.get(count).getKey() == height) {
                nums.add(this.pairs.get(count).getValue());
                count++;
            }
            output.add(nums);
            height++;
        }
        
        return output;
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        // from bottom to top
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int currHeight = Math.max(leftHeight, rightHeight) + 1;
        this.pairs.add(new Pair<Integer, Integer>(currHeight, root.val));
        return currHeight;
    }
    
}