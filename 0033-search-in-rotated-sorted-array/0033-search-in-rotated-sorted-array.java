class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(nums[mid] == target) 
                return mid;
            
            // Left portion of the array
            if(nums[left] <= nums[mid]){
                if(target < nums[left] || target > nums[mid])
                    left = mid + 1;
                else
                    right = mid -1;                    
            }
            
            // Right portion of the array
            else{
                if(target > nums[right] || target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            
        }
        
        return -1;
    }
}
