class Solution {
    public int solve(int[] cost, int index, HashMap<Integer, Integer> memo){
        if(index >= cost.length){
            return 0;
        }
        
        if(memo.containsKey(index)){
            return memo.get(index);
        }
        
        memo.put(index, cost[index] + Math.min(solve(cost, index + 1, memo), 
                                               solve(cost, index + 2, memo)));
        return memo.get(index);
    }

    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        memo.put(0, solve(cost, 0, memo));
        memo.put(1, solve(cost, 1, memo));
        return Math.min(memo.get(0), memo.get(1));
    }
}