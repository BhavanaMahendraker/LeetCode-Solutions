class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> subset, int[] nums, int i){
        if(i == nums.length){
            res.add(new ArrayList(subset));
            return;
        }
        
        // include all values
        subset.add(nums[i]);
        dfs(res, subset, nums, i + 1);
        subset.remove(subset.size() - 1);
        
        // skip upcoming duplicates
        // ex: in [1,2,2,3], we skip every instance of 2
        while(i + 1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        dfs(res, subset, nums, i + 1);
    }
}