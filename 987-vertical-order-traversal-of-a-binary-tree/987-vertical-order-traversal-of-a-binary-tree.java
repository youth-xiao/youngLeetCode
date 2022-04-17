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
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        if (a[0] != b[0]) return a[0] - b[0];
        if (a[1] != b[1]) return a[1] - b[1];
        return a[2] - b[2];
    });
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int[] info = new int[]{0, 0, root.val};
        pq.add(info);
        dfs(root, info);
        List<List<Integer>> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int[] curr = pq.peek();
            while (!pq.isEmpty() && pq.peek()[0] == curr[0]) {
                temp.add(pq.poll()[2]);
            }
            res.add(temp);
        }
        return res;
    }
    
    void dfs(TreeNode root, int[] info) {
        if (root.left != null) {
            int[] leftInfo = new int[]{info[0] - 1, info[1] + 1, root.left.val};
            pq.add(leftInfo);
            dfs(root.left, leftInfo);
        }
        if (root.right != null) {
            int[] rightInfo = new int[]{info[0] + 1, info[1] + 1, root.right.val};
            pq.add(rightInfo);
            dfs(root.right, rightInfo);
        }
    }
    
}





// class Point {
//     TreeNode node;
//     int x;
//     int y;
    
//     Point(TreeNode node, int x, int y) {
//         this.node = node;
//         this.x = x;
//         this.y = y;
//     }
// }

// class Solution {
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         PriorityQueue<Point> queue = new PriorityQueue<>(
//             (a, b) -> (a.y - b.y));
//         queue.offer(new Point(root, 0, 0));
//         List<List<Integer>> res = new ArrayList<>();
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 Point curr = queue.peek();
//                 if (curr.node.left != null) {
//                     queue.offer(new Point(node.left, curr.x + 1, curr.y - 1));
//                 }
//                 if (curr.node.right != null) {
//                     queue.offer(new Point(node.right, curr.x + 1, curr.y + 1))
//                 }
//             }
//         }
        
//     }
// }