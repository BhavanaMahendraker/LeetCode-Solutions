class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int num: nums){
            list.add(num);
        }
        
        dfs(res, list, 0);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> perm, int start){
        if(start == perm.size()){
            res.add(new ArrayList(perm));
            return;
        }
        
        for(int i = start; i < perm.size(); i++){
            Collections.swap(perm, start, i);
            dfs(res, perm, start + 1);
            Collections.swap(perm, start, i);
        }
    }
}