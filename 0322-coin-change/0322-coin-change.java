class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int [] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        
        for(int i=0; i<=amount; i++){
            for(int j=0; j<coins.length; j++){
                if(i - coins[j] >=0 && dp[i - coins[j]] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
    }
    /*
    public int coinChange(int[] coins, int amount) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        int minCoins = dfs(coins, amount, 0, memo);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
    
    public int dfs(int[] coins, int amount, int start, HashMap<Integer, Integer> memo){
        if(amount == 0){
            return 0;
        }
        if(amount < 0 || start >= coins.length){
            return Integer.MAX_VALUE;
        }
        if(memo.containsKey(amount))
            return memo.get(amount);
        
        int minCoins = Integer.MAX_VALUE;
        
        for(int i=start; i<coins.length; i++){
            int ans = dfs(coins, amount - coins[i], start, memo);
            if(ans != Integer.MAX_VALUE){
                minCoins =  Math.min(minCoins, 1 + ans);
                memo.put(amount, minCoins);
            }
        }
        
        return minCoins;
    }
    */
}