class Solution {
    public int findMin(int[] nums) {
        int res = nums[0], left = 0, right = nums.length -1 ;
        while(left <= right){
            if(nums[left] <= nums[right]){
                return Math.min(res, nums[left]);
            }
            int mid = (left + right) / 2;
            res = Math.min(nums[mid], res);
            if(nums[left] <= nums[mid]){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return res;
    }
}
