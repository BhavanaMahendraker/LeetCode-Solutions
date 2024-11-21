class Solution {
    public int climbStairs(int n) {
        // HashMap<Integer, Integer> memo = new HashMap<>();
        // return dfs(n, 0, memo);
        
        return dpSol(n);
    }
    
    private int dpSol(int n){
        int[] dp = new int[n+2];
        dp[n+1] = 0;
        dp[n] = 1;
        
        for(int i = n-1; i>= 0; i--){
            dp[i] = dp[i+1] + dp[i+2];
        }
        
        return dp[0];
    }
    
//     private int dfs(int n, int i, HashMap<Integer, Integer> memo){
//         if(i > n)
//             return 0;
        
//         if(i == n)
//             return 1;
        
//         if(memo.containsKey(i))
//             return memo.get(i);
        
//         int numOfWays = dfs(n, i+1, memo) + dfs(n, i+2, memo);
//         memo.put(i, numOfWays);
        
//         return memo.get(i);
//     }
}