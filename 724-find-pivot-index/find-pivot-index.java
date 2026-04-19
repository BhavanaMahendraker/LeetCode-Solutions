class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }

        int currSum = 0;
        for(int i=0; i<nums.length; i++){
            totalSum -= nums[i];
            if(totalSum == currSum){
                return i;
            }
            currSum += nums[i];
        }

        return -1;
    }
}

/*
totalSum = 28


[1,7,3,6,5,6]
       i

*/