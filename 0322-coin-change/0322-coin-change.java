class Solution {
    public int coinChange(int[] coins, int amount) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = dfs(coins, amount, 0, map);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    public int dfs(int[] coins, int amount, int start, HashMap<Integer, Integer> map){
        if(amount == 0){
            return 0;
        }
        if(start >= coins.length || amount < 0){
            return Integer.MAX_VALUE;
        }
        
        if(map.containsKey(amount))
            return map.get(amount);
        
        int min = Integer.MAX_VALUE;
        
        for(int i=start; i<coins.length; i++){
            int ans = dfs(coins, amount - coins[i], start, map);
            if(ans != Integer.MAX_VALUE)
                min = Math.min(min, 1 + ans);
        }
        map.put(amount, min);
        return map.get(amount);
    }
}