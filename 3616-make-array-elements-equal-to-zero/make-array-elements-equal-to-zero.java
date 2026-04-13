class Solution {
    public int countValidSelections(int[] nums) {
        if(nums.length == 1) {
            if(nums[0] == 0){
                return 2;
            } else {
                return 0;
            }
        }

        int[] prefixSum = new int[nums.length];
        int[] suffixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        suffixSum[nums.length - 1] = nums[nums.length - 1];
        int res = 0;

        for(int i=1; i<nums.length; i++){
            prefixSum[i] += prefixSum[i-1] + nums[i];
        }
        
        for(int i=nums.length-2; i>= 0; i--){
            suffixSum[i] += suffixSum[i+1] + nums[i];
        }

        for(int i=1; i< nums.length-1; i++){
            if(nums[i] == 0){
                if(prefixSum[i-1] == suffixSum[i+1]){
                    res += 2;
                } else if(Math.abs(prefixSum[i-1] - suffixSum[i+1]) == 1){
                    res += 1;
                }
            }
        }

        if(nums[0] == 0) {
            if (suffixSum[1] == 1){
                res += 1;
            } else if (suffixSum[1] == 0){
                res += 2;
            }
        }

        if(nums[nums.length - 1] == 0){
            if (prefixSum[nums.length - 2] == 1){
                res += 1;
            } else if (prefixSum[nums.length - 2] == 0){
                res += 2;
            }
        }

        return res;
    }
}