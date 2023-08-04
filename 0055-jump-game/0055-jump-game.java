class Solution {
    public boolean canJump(int[] nums) {
        boolean [] dp = new boolean[nums.length];
        dp[dp.length - 1] = true;
        boolean reachable = false;
        int goal = dp.length - 1;
        
        for(int i=dp.length -2; i>= 0; i--){
            if(i+nums[i] >= goal){
                //dp[i] = true;
                goal = i;
            }
        }
        
        return goal == 0;
    }
}