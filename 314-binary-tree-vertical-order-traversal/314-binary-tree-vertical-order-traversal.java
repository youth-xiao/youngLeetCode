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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        //  column
        Map<Integer, ArrayList<Integer>> columnTable = new HashMap<>();
        // Pair<TreeNode, ColumnNumber>
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        int column = 0;
        queue.offer(new Pair(root, column));
        
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            root = pair.getKey();
            column = pair.getValue();
            
            if (root != null) {
                if (!columnTable.containsKey(column)) {
                    columnTable.put(column, new ArrayList<>());
                }
                columnTable.get(column).add(root.val);
                queue.offer(new Pair(root.left, column - 1));
                queue.offer(new Pair(root.right, column + 1));
            }
        }
        
        List<Integer> sortedKeys = new ArrayList<Integer>(columnTable.keySet());
        Collections.sort(sortedKeys);
        for (int k : sortedKeys) {
            output.add(columnTable.get(k));
        }
        
        return output;
    }
}