class Solution {
    
    public void solve(List<List<Integer>> res, int[] nums, List<Integer> subset, int index){
        if(index >= nums.length){
            res.add(new ArrayList(subset));
            return;
        }
        
        // exclude curr
        solve(res, nums, subset, index+1);
        
        
        // include curr
        subset.add(nums[index]);
        solve(res, nums, subset, index+1);
        subset.remove(subset.size() - 1);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        solve(res, nums, new ArrayList<>(), 0);
        
        return res;
    }
}