class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2; i<dp.length; i++){
            dp[i] = Math.max(nums[i-1] + dp[i-2], dp[i-1]);
        }
        
        return dp[dp.length - 1];
    }
    
    /* recursive stack
    public int rob(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return dfs(nums, 0, memo);
    }
    
    public int dfs(int[] nums, int start, HashMap<Integer, Integer> memo){
        if(start >= nums.length){
            return 0;
        }
        if(memo.containsKey(start)){
            return memo.get(start);
        }
        int max = Math.max(nums[start] + dfs(nums, start + 2, memo), dfs(nums, start + 1, memo));
        memo.put(start, max);
        return max;
    }
    */
}