class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            
            if(nums[mid] == target)
                return mid;
            
            // Left portion of the array
            if(nums[left] <= nums[mid]){
                if(target < nums[left] || nums[mid] < target){
                    left = mid + 1;
                } else{
                    right = mid - 1;
                }
            }
            // Right portion of the array
            else{
                if(target > nums[right] || nums[mid] > target){
                    right = mid - 1;
                } else{
                    left = mid + 1;
                }
            }
        }
        
        return -1;
    }
}

/*
4,5,6,7,0,1,2
      m
l
            r
            
nums[m] == target
    return m

nums[l] <= nums[m]{
    target < nums[left] || nums[m] < target
        l = m + 1
    else
        r = m - 1

} else{
    nums[r] < target || nums[m] < target
        r = m - 1
    else
        l = m + 1
}

*/