class Solution {
    public int rob(int[] nums) {
        // return dfs(nums, 0);
        
        // return memoization(nums, 0, new HashMap<>());
        
        // return dp(nums);
        
        return dp2(nums);
    }
    
    private int dp2(int[] nums){
        int second =0, first = 0;
        
        for(int i=nums.length-1; i>=0; i--){
            int curr = Math.max(nums[i] + second, first);
            second = first;
            first = curr;
        }
        
        return first;
    }
    
    private int dp(int[] nums){
        int[] dp = new int[nums.length + 2];
        
        dp[nums.length + 1] = 0;
        dp[nums.length] = 0;
        
        for(int i=nums.length-1; i>=0; i--){
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }
        
        return dp[0];
    }
    
    // TC: O(N), SC: O(N) 
    private int memoization(int[] nums, int currIndex, HashMap<Integer, Integer> memo){
        if(currIndex >= nums.length){
            return 0;
        }
        
        if(memo.containsKey(currIndex))
            return memo.get(currIndex);
        
        int includingCurrHouse = nums[currIndex] + dfs(nums, currIndex + 2);
        int excludingCurrHouse = dfs(nums, currIndex + 1);
        
        int maxMoney = Math.max(includingCurrHouse, excludingCurrHouse);
        memo.put(currIndex, maxMoney);
        
        return maxMoney;
    }
    

    // TC: O(2^N), SC: O(N) 
    private int dfs(int[] nums, int currIndex){
        if(currIndex >= nums.length){
            return 0;
        }
        
        int includingCurrHouse = nums[currIndex] + dfs(nums, currIndex + 2);
        int excludingCurrHouse = dfs(nums, currIndex + 1);
        
        return Math.max(includingCurrHouse, excludingCurrHouse);
    }
}