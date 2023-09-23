class Solution {
    public int[] countBits(int n) {
        
        // TC: O(N), SC: O(N)
        int[] dp = new int[n + 1];
        int offset = 1;
        
        
        for(int i=1; i<dp.length; i++){
            if(offset * 2 == i){
                offset = i;
            }
            dp[i] = 1 + dp[i - offset];
        }
        
        return dp;
        
        /*
        // TC: O(NLogN) SC: O(N)
        int [] ans = new int[n + 1];
        for(int i=0; i<=n; i++){
            int curr = i;
            
            while(curr != 0){
                if(curr % 2 == 1)
                    ans[i]++;
                curr /= 2;
            }
        }
        
        return ans;
        */
    }
}