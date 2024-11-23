class Solution {
    public int combinationSum4(int[] nums, int target) {
        // return dfs(nums, target, 0);
        // return memoization(nums, target, 0, new HashMap<>());
        return dp(nums, target);
    }
    
    public int dfs(int[]nums, int target, int index){
        if(index >= nums.length || target < 0)
            return 0;
        
        if(target == 0)
            return 1;
        
        int including = 0;
        if(nums[index] <= target)
            including = dfs(nums, target - nums[index], 0);
        int excluding = dfs(nums, target, index + 1);
        
        return including + excluding;
    }
    
    public int memoization(int[]nums, int target, int index, HashMap<Integer, Integer> memo){
        if(index >= nums.length || target < 0)
            return 0;
        
        if(target == 0)
            return 1;
        
        if(memo.containsKey(target))
            return memo.get(target);
        
        int including = 0;
        if(nums[index] <= target)
            including = memoization(nums, target - nums[index], 0, memo);
        int excluding = memoization(nums, target, index + 1, memo);
        
        memo.put(target, including + excluding);
        
        return memo.get(target);
    }
    
    public int dp(int[]nums, int target){
        int[] dp = new int[target+1];
        dp[0] = 1;
        
        for(int i=0; i<=target; i++){
            for(int j=0; j< nums.length; j++){
                if(i >= nums[j]){
                    dp[i] = dp[i-nums[j]] + dp[i];
                }
            }
        }
        
        return dp[target];
        
    }
}