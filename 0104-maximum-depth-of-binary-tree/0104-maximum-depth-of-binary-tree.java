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
    public int maxDepth(TreeNode root) {
        
        // Recursive Solution
        // TC: O(N), SC: O(N)
        if(root == null)
            return 0;
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        
        
        /*
        // BFS Solution
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        if(root != null){
            q.add(root);
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                TreeNode node = q.poll();
                if(node.left != null)
                    q.add(node.left);

                if(node.right != null)
                    q.add(node.right);
            }
            level++;
        }
        
        return level; 
        */
    }
}