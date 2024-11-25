class Solution {
    public int coinChange(int[] coins, int amount) {
        // int res = solveRec(coins, amount);
        // int res = solveMemo(coins, amount, new HashMap<>());
        int res = solveDP(coins, amount);
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    public int solveDP(int[] coins, int amount){
        int[] dp = new int[amount+1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 1; i<=amount; i++){
            for(int j=0; j<coins.length; j++){
                if(i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        
        return dp[amount];
    }
        
    public int solveMemo(int[] coins, int amount, HashMap<Integer, Integer> memo){
        if(amount == 0){
            return 0;
        }
        
        if(amount < 0){
            return Integer.MAX_VALUE;
        }
        
        if(memo.containsKey(amount))
            return memo.get(amount);
        
        int minCoins = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            int curr = solveMemo(coins, amount - coins[i], memo);
            if(curr != Integer.MAX_VALUE)
                minCoins = Math.min(minCoins, curr + 1);
        }
        
        memo.put(amount, minCoins);
        return memo.get(amount);
    }
    
    public int solveRec(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }
        
        if(amount < 0){
            return Integer.MAX_VALUE;
        }
        
        int minCoins = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            int curr = solveRec(coins, amount - coins[i]);
            if(curr < Integer.MAX_VALUE)
                minCoins = Math.min(minCoins, curr + 1);
        }
        
        return minCoins;
    }
}