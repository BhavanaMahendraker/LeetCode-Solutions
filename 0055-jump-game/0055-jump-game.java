class Solution {
    public boolean canJump(int[] nums) {
        boolean [] dp = new boolean[nums.length];
        dp[dp.length - 1] = true;
        int goal = dp.length - 1;
        
        for(int i=dp.length -2; i>= 0; i--){
            if(i+nums[i] >= goal || dp[i + nums[i]] == true){
                dp[i] = true;
                goal = i;
            }
        }
        
        return dp[0];
    }
}