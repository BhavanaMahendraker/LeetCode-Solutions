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
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        
        return root;
        
        
        /*
        TreeNode curr = root;
        
        while(curr != null){
            if(p.val > curr.val && q.val > curr.val)
                curr = curr.right;
            else if(p.val < curr.val && q.val < curr.val)
                curr = curr.left;
            else
                return curr;
        }
    
        return curr;
        */
    }
}