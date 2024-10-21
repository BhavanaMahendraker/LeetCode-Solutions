class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int left = i+1, right = nums.length - 1;
            
            while(left < right){
                
                int currSum = nums[i] + nums[left] + nums[right];
                
                if(currSum < 0){
                    left++;
                } else if(currSum > 0){
                    right--;
                } else{
                    ArrayList<Integer> list = new ArrayList<>();
                    Collections.addAll(list, nums[i], nums[left], nums[right]);
                    res.add(list);
                    left++;
                    while(left < right && nums[left] == nums[left - 1])
                        left++;
                }
            }
        }
        
        return res;
    }
}