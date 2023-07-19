class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 0, 0, target, candidates);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> comb, int start, int sum, int target, int[] candidates){
        if(sum == target){
            res.add(new ArrayList(comb));
            return;
        }
        
        if(sum > target || start >= candidates.length)
            return;
        
        // Neetcode
        comb.add(candidates[start]);
        dfs(res, comb, start, sum + candidates[start], target, candidates);
        comb.remove(comb.size() - 1);
        
        dfs(res, comb, start + 1, sum, target, candidates);
        
        /*
        // loop solution 
        for(int i = start; i < candidates.length; i++){
            if(sum + candidates[i] > target)
                continue;
            comb.add(candidates[i]);
            dfs(res, comb, i, sum + candidates[i], target, candidates);
            comb.remove(comb.size() - 1);
        }
        */
    }
}