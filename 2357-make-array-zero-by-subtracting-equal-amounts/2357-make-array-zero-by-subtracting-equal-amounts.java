class Solution {
    public int minimumOperations(int[] nums) {
        if(nums.length == 1){
            if(nums[0] == 0)
                return 0;
            else 
                return 1;
        }
        
        nonZeroPresent(nums);
        int numOfOperations = 0;
        
        while(nonZeroPresent(nums)){
            int min = findSmallestNonZero(nums);
            for(int i=0; i<nums.length; i++){
                if(nums[i] != 0){
                    nums[i] -= min;
                }
            }
            numOfOperations++;
        }
        return numOfOperations;
    }
    
    private boolean nonZeroPresent(int[] nums){
        for(int num: nums){
            if(num != 0)
                return true;
        }
        return false;
    }
    
    private int findSmallestNonZero(int []nums){
        int min = Integer.MAX_VALUE;
        for(int num: nums){
            if(num != 0 && min > num){
                min = num;
            }
        }
        return min;
    }
}