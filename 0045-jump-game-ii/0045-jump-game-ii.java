class Solution {
    public int jump(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[dp.length -1] = 0;
        
        for(int i=dp.length-2; i>= 0; i--){
            int jumpLen = nums[i];
            while(jumpLen > 0){
                if(i + jumpLen < nums.length && dp[i + jumpLen] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], 1 + dp[i + jumpLen]);
                jumpLen--;
            }
        }
        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }
}