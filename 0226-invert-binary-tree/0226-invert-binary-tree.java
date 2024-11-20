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
    public TreeNode invertTree(TreeNode root) {
        // Iterative Solution
        if(root == null)
            return null;
        
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if(curr.left != null)
                stack.push(curr.left);
            if(curr.right != null)
                stack.push(curr.right);
        }
        
        return root;
        
        // Recursive Solution
//         if(root == null || (root.left == null && root.right == null)){
//             return root;
//         }
        
//         TreeNode left = invertTree(root.left);
//         TreeNode right = invertTree(root.right);
        
//         root.right = left;
//         root.left = right;
        
//         return root;
    }
}