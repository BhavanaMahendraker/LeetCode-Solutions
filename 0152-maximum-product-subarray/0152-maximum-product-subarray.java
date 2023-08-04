class Solution {
    public int maxProduct(int[] nums) {
        int minProduct = 1, maxProduct = 1;
        int res = Integer.MIN_VALUE;
        for(int num: nums)
            res = Math.max(res, num);
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                minProduct = maxProduct = 1;
            } else{
                int tempMin = minProduct;
                int tempMax = maxProduct;
                minProduct = Math.min(nums[i], Math.min(nums[i] * tempMin, nums[i] * tempMax));
                maxProduct = Math.max(nums[i], Math.max(nums[i] * tempMin, nums[i] * tempMax));
                res = Math.max(res, maxProduct);
            }
        }
        
        return res;
    }
}