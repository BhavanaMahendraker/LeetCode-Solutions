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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // return neetcodeSolution(preorder, inorder);
        return loveBabbarSolution(preorder, inorder, new int[]{0}, 0, inorder.length - 1);
    }
    
    private TreeNode loveBabbarSolution(int[] preorder, int[] inorder, 
                                        int[] preorderIndex, int inorderStart, int inorderEnd) {
        if(preorderIndex[0] >= preorder.length || inorderStart > inorderEnd){
            return null;
        }
        
        int currElement = preorder[preorderIndex[0]++];
        TreeNode root = new TreeNode(currElement);
        
        int mid = -1;
        for(int i=0; i<preorder.length; i++){
            if(inorder[i] == currElement){
                mid = i;
                break;
            }
        }
        
        root.left = loveBabbarSolution(preorder, inorder, preorderIndex, inorderStart, mid - 1);
        root.right = loveBabbarSolution(preorder, inorder, preorderIndex, mid + 1, inorderEnd);
        
        return root;        
    }
    
    private TreeNode neetcodeSolution(int[] preorder, int[] inorder) {
        if(preorder.length == 0 && inorder.length == 0){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[0]);
        
        int mid = 0;
        for(int i = 0; i<inorder.length; i++){
            if(inorder[i] == preorder[0]){
                mid = i;
                break;
            }
        }
        
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1),
                              Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length),
                             Arrays.copyOfRange(inorder, mid+1, inorder.length));
        
        return root;
    }
}