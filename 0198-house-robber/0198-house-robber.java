class Solution {
    public int rob(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return dfs(nums, 0, memo);
    }
    
    public int dfs(int[] nums, int start, HashMap<Integer, Integer> memo){
        if(start >= nums.length){
            return 0;
        }
        if(memo.containsKey(start)){
            return memo.get(start);
        }
        int max = Math.max(nums[start] + dfs(nums, start + 2, memo), dfs(nums, start + 1, memo));
        memo.put(start, max);
        return max;
    }
}