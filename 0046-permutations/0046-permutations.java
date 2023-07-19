class Solution {
    // NeetCode
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // Base case
        if (nums.length == 1) {
            List<Integer> singlePermutation = new ArrayList<>();
            singlePermutation.add(nums[0]);
            res.add(singlePermutation);
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int[] remainingNums = removeElement(nums, i);
            List<List<Integer>> perms = permute(remainingNums);

            for (List<Integer> perm : perms) {
                perm.add(n);
            }
            res.addAll(perms);
        }

        return res;
    }

    private int[] removeElement(int[] nums, int index) {
        int[] newArray = new int[nums.length - 1];
        int newArrayIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i != index) {
                newArray[newArrayIndex] = nums[i];
                newArrayIndex++;
            }
        }

        return newArray;
    }    
    
    /* 
    // Swapping method
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
    */
}