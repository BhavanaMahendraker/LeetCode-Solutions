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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode node, TreeNode low, TreeNode high){
        if(node == null)
            return true;
        
        if((low != null && node.val <= low.val) || (high != null && node.val >= high.val))
            return false;
        
        return isValidBST(node.left, low, node) && isValidBST(node.right, node, high);
    }
}