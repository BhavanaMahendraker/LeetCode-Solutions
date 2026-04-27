class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, product = 1, resCount = 0;

        for(int right =0; right < nums.length; right++){
            product *= nums[right];

            while(left <= right && product >= k){
                product /= nums[left];
                left++;
            }
            resCount += right - left + 1;
        }

        return resCount;
    }
}