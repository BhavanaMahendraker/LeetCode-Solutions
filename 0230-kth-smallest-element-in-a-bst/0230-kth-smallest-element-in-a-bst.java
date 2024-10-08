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
    public int kthSmallest(TreeNode root, int k) {
        /* HashSet In-Order method
        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> visited = new HashSet<>();
        stack.push(root);
        visited.add(root);
        
        while(!stack.isEmpty()){
            while(stack.peek().left != null && !visited.contains(stack.peek().left)){
                TreeNode left = stack.peek().left;
                visited.add(left);
                stack.push(left);
            }
            TreeNode curr = stack.pop();
            k--;
            if(k == 0)
                return curr.val;
            if(curr.right != null)
                stack.push(curr.right);
        }
        return -1;
        */
        
        // Inorder traversal
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root; // pointer
        
        while(k >= 0){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            k--;
            if(k == 0)
                return curr.val;
            curr = curr.right; // Point at right (even if null)
                                // but push to stack in next iteration
        }
        return -1;
        
    }
}