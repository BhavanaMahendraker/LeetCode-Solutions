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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameterHeight = new int[2];
        dfs(root, diameterHeight);
        return diameterHeight[0];
    }
    
    public int dfs(TreeNode node, int[] diameterHeight){
        if(node == null){
            return 0;
        }
        
        int left = dfs(node.left, diameterHeight);
        int right = dfs(node.right, diameterHeight);
        diameterHeight[0] = Math.max(diameterHeight[0], left + right);
        diameterHeight[1] = 1+ Math.max(left, right);
        
        return diameterHeight[1];
    }
}