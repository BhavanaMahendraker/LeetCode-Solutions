/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {   
        // Iterative Solution
        if (root == null || p == null || q == null) {
            return null;
        }
        TreeNode curr = root;
        
        while(curr != null){
            if(p.val < curr.val && q.val < curr.val)
                curr = curr.left;
            else if(p.val > curr.val && q.val > curr.val)
                curr = curr.right;
            else 
                return curr;
        }
        
        return null;
        
        // Recursive Solution
//         if (root == null || p == null || q == null) {
//             return null;
//         }
//         if(p.val < root.val && q.val < root.val)
//             return lowestCommonAncestor(root.left, p, q);
        
//         if(p.val > root.val && q.val > root.val)
//             return lowestCommonAncestor(root.right, p, q);
        
//         return root;
    }
}