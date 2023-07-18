class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrackDFS(res, new ArrayList<>(), 0, nums);
        return res;
    }
    
    public void backtrackDFS(List<List<Integer>> res, List<Integer> subset, int start, int[] nums){
        if(start >= nums.length){
            res.add(new ArrayList(subset));
            return;
        }
        
        // append new element
        subset.add(nums[start]);
        backtrackDFS(res, subset, start + 1, nums);
        
        // append empty
        subset.remove(subset.size() - 1);
        backtrackDFS(res, subset, start + 1, nums);
    }
}