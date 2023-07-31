class Solution {
    public int climbStairs(int n) {
        /*
        // TC: O(N), SC: O(N)
        int[] dp = new int[n+1];
        
        dp[n] = dp[n-1] = 1;
        
        for(int i=dp.length - 3; i >= 0; i--){
            dp[i] = dp[i+1] + dp[i+2];
        }
        
        return dp[0];
        */
        
        int first = 1, second = 1;
        
        for(int i=n - 2; i >= 0; i--){
            int third = first + second;
            second = first; 
            first = third;
        }
        
        return first;
    }
}