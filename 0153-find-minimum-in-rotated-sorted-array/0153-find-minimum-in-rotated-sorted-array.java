class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, res = nums[0];
        
        while(left <= right){
            if(nums[left] <= nums[right]){
                return Math.min(res, nums[left]);
            }
            
            int mid = left + (right - left) / 2;
            res = Math.min(res, nums[mid]);
            
            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else if(nums[left] > nums[mid]){
                right = mid - 1;
            }
        }
        
        return res;
    }
}

/*

18,11,13,15

l
   r


lVal <= rVal || m-1Val > mVal
    return l

mVal > rVal
    l = m + 1

lVal > mVal
    r = m -1

*/