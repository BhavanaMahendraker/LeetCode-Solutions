class Solution {
    public int recursive(int[] cost, int index){
        if(index >= cost.length){
            return 0;
        }        
        return cost[index] + Math.min(recursive(cost, index + 1),
                                        recursive(cost, index + 2));
    }
    
    public int topDown(int[] cost, int index, HashMap<Integer, Integer> memo){
        if(index >= cost.length){
            return 0;
        }
        
        // STEP 3
        if(memo.containsKey(index)){
            return memo.get(index);
        }
        
        // STEP 2
        memo.put(index, cost[index] + Math.min(topDown(cost, index + 1, memo), 
                                               topDown(cost, index + 2, memo)));
        return memo.get(index);
    }
    
    public int bottomUp(int[] cost){
        int n = cost.length;
        int[] dp = new int[n + 2];
        
        for(int i=n-1; i>=0; i--){
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }        
        return Math.min(dp[0], dp[1]);
    }

    public int minCostClimbingStairs(int[] cost) {
        
        //  Recursive
        //return Math.min(recursive(cost, 0), recursive(cost, 1));
        
        // Top Down
        // STEP 1
        //HashMap<Integer, Integer> memo = new HashMap<>();
        //return Math.min(topDown(cost, 0, memo), topDown(cost, 1, memo));
        
        // Bottom Up
        // STEP 1
        return bottomUp(cost);
    }
}