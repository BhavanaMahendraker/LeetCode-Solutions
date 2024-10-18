class Solution {
    public int maxSubArray(int[] nums) {
        
        // Kadane's Algorithm
        // TC: O(n), SC: O(1)
        int left=0, right=0, maxSum = nums[0], currSum = 0;
        
        while(right < nums.length){
            if(currSum < 0){
                left = right;
                currSum = 0;
            }
            
            currSum += nums[right];
            maxSum = Math.max(maxSum, currSum);
            right++;
        }
        
        return maxSum;
       
        
//         // TC: O(n^2), SC: O(1)
//         int maxSum = nums[0];
        
//         for(int i =0; i<nums.length; i++){
//             int currSum = 0;
//             for(int j=i; j<nums.length; j++){
//                 currSum += nums[j];
//                 maxSum = Math.max(maxSum, currSum);
//             }
//         }
//         return maxSum;
    }
}

/*
[-2,1,-3,4,-1,2,1,-5,4]
         i
                     j
  
  currSum = 4 + 1 = 5
  maxSum = 6
  
  if currSum <0
    currSum =0
    
  currSum += nums[j]
  
  maxSum = max of maxSum, currSum



*/