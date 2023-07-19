class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        
        dfs(res, new ArrayList<>(), candidates, 0, target);
        
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int i, int target){
        if(target == 0){
            res.add(new ArrayList(list));
            return;
        }
        
        if(target < 0 || i >= nums.length)
            return;
        
        list.add(nums[i]);
        dfs(res, list, nums, i+1, target - nums[i]);
        list.remove(list.size() - 1);
        
        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        dfs(res,list, nums, i+1, target);
    }
}