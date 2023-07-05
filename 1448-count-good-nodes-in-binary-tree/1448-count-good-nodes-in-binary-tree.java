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
    public int goodNodes(TreeNode root) {
        return root == null ? 0 : dfs(root, root.val);
    }
    
    public int dfs(TreeNode node, int max){ // return count;
        if(node == null)
            return 0;
        
        int res = 0;
        
        if(node.val >= max){
            res += 1;
            max = Math.max(max, node.val);
        }
        
        res += dfs(node.left, max) + dfs(node.right, max);
        
        return res;
    }
    
}