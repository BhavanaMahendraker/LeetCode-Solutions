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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
    
    public int dfs(TreeNode node){
        if(node == null)
            return 0;
        
        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);
        res = Math.max(res, left + right + node.val);
        
        return Math.max(left, right) + node.val;
    }
}