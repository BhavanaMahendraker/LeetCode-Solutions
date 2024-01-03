class Solution {
    public int Recursive(int[] cost, int index){
        if(index >= cost.length){
            return 0;
        }        
        return cost[index] + Math.min(Recursive(cost, index + 1),
                                        Recursive(cost, index + 2));
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

    public int minCostClimbingStairs(int[] cost) {
        
        //  Recursive
        //return Math.min(Recursive(cost, 0), Recursive(cost, 1));
        
        // Top Down
        // STEP 1
        HashMap<Integer, Integer> memo = new HashMap<>();
        return Math.min(topDown(cost, 0, memo), topDown(cost, 1, memo));
    }
}