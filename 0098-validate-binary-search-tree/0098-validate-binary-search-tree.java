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
        return validate(root, null, null);
    }
    
    public boolean validate(TreeNode node, TreeNode low, TreeNode high){
        if(node == null)
            return true;
        if((low != null && node.val <= low.val) || (high != null && node.val >= high.val))
            return false;
        
        return validate(node.left, low, node) 
            && validate(node.right, node, high);
    }    
}