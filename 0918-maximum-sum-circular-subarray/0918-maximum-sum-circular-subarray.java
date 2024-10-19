class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int globalMax = nums[0], globalMin = nums[0];
        int currMin = 0, currMax = 0, totalSum = 0;
        
        for(int i=0; i<nums.length; i++){
            currMax = Math.max(currMax + nums[i], nums[i]);
            currMin = Math.min(currMin + nums[i], nums[i]);
            totalSum += nums[i];
            globalMax = Math.max(globalMax, currMax);
            globalMin = Math.min(globalMin, currMin);
        }
        
        if(globalMax > 0)
            return Math.max(globalMax, totalSum - globalMin);
        
        return globalMax;
    }
}
