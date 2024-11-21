class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        
        // return Math.max(dfs(nums, 0, nums.length - 1), dfs(nums, 1, nums.length));
        
        // return Math.max(memoization(nums, 0, nums.length - 1, new HashMap<>()),
        //                 memoization(nums, 1, nums.length, new HashMap<>()));
        
        return Math.max(dp1(nums, 0, nums.length - 1), dp1(nums, 1, nums.length));
    }
    
    // TC: O(N)    SC: O(N) ---> Time Limit Exceeded
    private int dp1(int[] nums, int start, int end){
        int[] dp = new int[end+2];
        dp[end] = 0;
        dp[end+1] = 0;
        
        for(int i=end-1; i>=start; i--){
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }
        
        return Math.max(dp[0], dp[1]);
    }
    
    // TC: O(N)    SC: O(N) ---> Time Limit Exceeded
    private int memoization(int[] nums, int currIndex, int end, HashMap<Integer, Integer> memo){
        if(currIndex >= end)
            return 0;
        
        if(memo.containsKey(currIndex))
            return memo.get(currIndex);
        
        int includingCurrHouse = nums[currIndex] + dfs(nums, currIndex + 2, end);
        int excludingCurrHouse = dfs(nums, currIndex + 1, end);
        
        memo.put(currIndex, Math.max(includingCurrHouse, excludingCurrHouse));
        
        return memo.get(currIndex);
    }
    
    // TC: O(2^N)    SC: O(N)
    private int dfs(int[] nums, int currIndex, int end){
        if(currIndex >= end)
            return 0;
        
        int includingCurrHouse = nums[currIndex] + dfs(nums, currIndex + 2, end);
        int excludingCurrHouse = dfs(nums, currIndex + 1, end);
        
        return Math.max(includingCurrHouse, excludingCurrHouse);
    }
}