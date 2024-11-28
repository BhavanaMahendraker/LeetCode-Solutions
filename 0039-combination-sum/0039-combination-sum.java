class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), res, 0);
        return res;
    }
    
    private void helper(int[] candidates, int target, List<Integer> comb, List<List<Integer>> res, int start){
        if(target == 0){
            res.add(new ArrayList<>(comb));
            return;
        }
        
        if(target < 0 || start >= candidates.length){
            return;
        }
        
        comb.add(candidates[start]);
        helper(candidates, target - candidates[start], comb, res, start);
        comb.remove(comb.size() - 1);
        helper(candidates, target, comb, res, start + 1);
        
        // for(int i=start; i<candidates.length; i++){
        //     comb.add(candidates[i]);
        //     helper(candidates, target - candidates[i], comb, res, i);
        //     comb.remove(comb.size() - 1);
        // }
    }
}