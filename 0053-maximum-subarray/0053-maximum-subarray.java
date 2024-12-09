class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];
        
        for(int i=1; i<nums.length; i++){
            if(currSum < 0){
                currSum = 0;
            }
            
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }
}

/*
[-2,1,-3,4,-1,2,1,-5,4]
       i
    
currSum = -2
maxSum = 1

if currSum < nums[i]
    currSum = 0

currSum += nums[i]
maxSum = max(maxSum, currSum)

*/