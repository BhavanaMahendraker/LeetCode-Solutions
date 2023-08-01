class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        return Math.max(helper(nums, 0, nums.length-1), helper(nums, 1, nums.length));
    }
    
    public int helper(int[] nums, int start, int end){
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        
        for(int i=2; i<dp.length; i++){
            dp[i] = Math.max(nums[start++] + dp[i-2], dp[i-1]);
        }
        
        return dp[dp.length -1];
    }
}