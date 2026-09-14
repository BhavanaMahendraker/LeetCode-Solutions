class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, new ArrayList<>(), res, nums);
        return res;
    }

    private void dfs(int i, List<Integer> comb, List<List<Integer>>res, int[] nums){
        if(i == nums.length){
            res.add(new ArrayList(comb));
            return;
        }

        comb.add(nums[i]);
        dfs(i+1, comb, res, nums);
        comb.remove(comb.size() - 1);
        dfs(i+1, comb, res, nums);
    }
}