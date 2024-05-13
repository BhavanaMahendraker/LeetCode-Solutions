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
    public int minDepth(TreeNode root) {
        
        if(root == null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            
            while(size-- > 0){
                TreeNode currNode = q.poll();
                
                if(currNode.left == null && currNode.right == null)
                    return level;
                if(currNode.left != null)
                    q.add(currNode.left);
                if(currNode.right != null)
                    q.add(currNode.right);
                
            }
            
        }
        
        return level;
        
    }
}

/*

queue -> add root
loop until queue empty
increment level
loop through queue size (number of elements at curr level)
if curr node has no left or right child return level
else add left and or right child nodes
continue

*/