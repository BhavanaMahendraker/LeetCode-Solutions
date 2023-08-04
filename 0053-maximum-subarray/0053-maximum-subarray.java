class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], sum = 0;
        
        for(int num: nums){
            if(sum < 0 && num > sum)
                sum = num;
            else
                sum += num;
            max = Math.max(sum, max);
        }
        
        return max;
    }
}