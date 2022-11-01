/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// // https://www.youtube.com/watch?v=BN2W9r1YW2w
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if (root == null || root == p || root == q) {
//             return root;
//         }
//         TreeNode left = lowestCommonAncestor(root.left, p, q);
//         TreeNode right = lowestCommonAncestor(root.right, p, q);
        
//         if (left != null && right != null) {
//             return root;
//         }
        
//         if (left != null) return left;
//         return right;
//     }
// }


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>(); // Notice: we use this stack only during line 37-47. 
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>(); // 用map来记录当前node和她的父母
        stack.push(root);
        parentMap.put(root, null);
        // 从上往下遍历！！！
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) { // 这个loop的功能就是找到p、q的位置
            TreeNode node = stack.pop();
            if (node.left != null) { // 一直找 要么在叶子前找到 要么一直找到叶子
                stack.push(node.left);
                parentMap.put(node.left, node);
            }
            if (node.right != null) {
                stack.push(node.right);
                parentMap.put(node.right, node);
            }
        }
        // we don't need to use stack anymore, because it only serves when we try to traverse to find the positions of p and q.
        // KEY POINT: 从下往上遍历！！！
        List<TreeNode> ancestor = new ArrayList<>();
        while (p != null) { // 把p节点到root的路径遍历一遍 从下往上
            ancestor.add(p);
            p = parentMap.get(p); // update p node to its parent node
        }
        // this while loop goes on until the path of p and q converge!!! when it converges, the point of convergement is the lowest common ancestor (we can ensure this is the lowest one because we iterate from bottom to top, and stop the search once converges)
        while (!ancestor.contains(q)) { // 再在ancestor的pool里 从下往上找common ancestor
            q = parentMap.get(q); // 如果找不到 就更新q（更新到q的父母）
        }
        return q;
    }
}



// // 这道题的思路就是把p和q的bottom-up til root 的路径找出来 然后找最近的common node（所以要i-- j--)
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if (root == null) return null;
//         List<TreeNode> pathP = findPath(root, p);
//         List<TreeNode> pathQ = findPath(root, q);
//         int i = pathP.size() - 1;
//         int j = pathQ.size() - 1;
//         while (i >= 0 && j >= 0 && pathP.get(i) == pathQ.get(j)) {
//             i--;
//             j--;
//         }
//         return pathP.get(i + 1);
//     }
    
//     private List<TreeNode> findPath (TreeNode root, TreeNode target) {
//         List<TreeNode> path = new ArrayList<>();
//         if (root == null) return path;
//         List<TreeNode> leftPath = findPath(root.left, target);
//         List<TreeNode> rightPath = findPath(root.right, target);
//         path.addAll(leftPath);
//         path.addAll(rightPath);
//         if (path.size() != 0 || root == target) {
//             path.add(root);
//         }
//         return path;
//     }
// }

