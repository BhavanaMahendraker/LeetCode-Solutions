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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        if(k == 0){
            res.add(target.val);
            return res;
        }
        
        
        // Create undirected graph
        HashMap<TreeNode, ArrayList<TreeNode>> adj = new HashMap<>();
        HashSet<TreeNode> visited = new HashSet<>();
        if(root.left != null) {
            createUndirectedGraph(root, root.left, adj);
        }
        if(root.right != null){ 
            createUndirectedGraph(root, root.right, adj);
        }
        
        visited.add(target);
        for(TreeNode neigh: adj.getOrDefault(target, new ArrayList<>())){
            getTheAnswer(res, adj, visited, neigh, k-1);
        }
        
        return res;
    }
    
    private void createUndirectedGraph(TreeNode parent, TreeNode child, HashMap<TreeNode, ArrayList<TreeNode>> adj){
        adj.putIfAbsent(parent, new ArrayList<>());
        adj.putIfAbsent(child, new ArrayList<>());
        
        adj.get(parent).add(child);
        adj.get(child).add(parent);
        
        if(child.left != null) {
            createUndirectedGraph(child, child.left, adj);
        }
        if(child.right != null){ 
            createUndirectedGraph(child, child.right, adj);
        }
    }
    
    private void getTheAnswer(ArrayList<Integer> res, HashMap<TreeNode, ArrayList<TreeNode>> adj, HashSet<TreeNode> visited, TreeNode curr, int k){
        visited.add(curr);
    
        if(k == 0){
            res.add(curr.val);
            return;
        }
        
        if(curr == null){
            return;
        }
        
        for(TreeNode neigh: adj.getOrDefault(curr, new ArrayList<>())){
            if(visited.contains(neigh))
                continue;
            getTheAnswer(res, adj, visited, neigh, k-1);
        }
    }
    
}