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
    public List<Double> averageOfLevels(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> result = new ArrayList();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            double levelSum = 0;
            int i =0;
            
            while(i++ < size){
                TreeNode curr = q.poll();
                levelSum += curr.val;
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
                
            }
            
            result.add(levelSum / size);
        }
        
        return result;
    }
}

/*

3
9, 20
15, 7


QUEUE
3
pop 3 
queue size times loop
add current node value to the totalSum of current level
add current node's (3's) children to the queue
repeat the process 



*/