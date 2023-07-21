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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) return res;
        
        q.add(root);

        while(!q.isEmpty()){
          int size = q.size();
          List<Integer> list = new ArrayList<>();
          while(size-- > 0){
            TreeNode node = q.poll();
            list.add(node.val);
            if(node.left != null)
              q.add(node.left);
            if(node.right != null)
              q.add(node.right);
          }
          res.add(new ArrayList(list));
        }

        for(int i=0; i<res.size(); i++){
          if (i % 2 != 0)
            Collections.reverse(res.get(i));
        }
        return res;
    }
}