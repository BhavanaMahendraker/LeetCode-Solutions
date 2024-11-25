class Solution {
    public int coinChange(int[] coins, int amount) {
        // int res = solveRec(coins, amount);
        int res = solveMemo(coins, amount, new HashMap<>());
        
        return res == Integer.MAX_VALUE ? -1 : res;
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