class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }

        int currSum = 0;
        for(int i=0; i<nums.length; i++){
            if(totalSum - nums[i] - currSum == currSum){
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

currSum = 17

28 != 2*11




*/