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
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        
        if(leftHeight == rightHeight)
            return (1 << leftHeight) - 1;
        
        return 1 + countNodes(root.left) +  countNodes(root.right);
    }
    
    public int getLeftHeight(TreeNode node){
        if(node == null)
            return 0;
        return 1 + getLeftHeight(node.left);
    }
    
    public int getRightHeight(TreeNode node){
        if(node == null)
            return 0;
        return 1 + getRightHeight(node.right);
    }
}