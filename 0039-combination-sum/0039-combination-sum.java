class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> comb, int[] candidates, int target, int start){
        if(target < 0 || start >= candidates.length){
            return;
        }
        
        if(target == 0){
            res.add(new ArrayList(comb));
        }
        
        for(int i=start; i<candidates.length; i++){
            comb.add(candidates[i]);
            dfs(res, comb, candidates, target - candidates[i], i);
            comb.remove(comb.size() - 1);
        }
    }
}