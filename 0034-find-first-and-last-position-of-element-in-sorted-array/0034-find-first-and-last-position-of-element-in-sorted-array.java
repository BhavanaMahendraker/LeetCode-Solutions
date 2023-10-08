class Solution {
    int first = -1, last = -1;
    public void lastOcc(int[] nums, int target, int left, int right){
        if(left > right){
            return;
        }
        
        int mid = (left + right) / 2;
        
        if(nums[mid] == target){
            last = mid;
            lastOcc(nums, target, mid + 1, right);
        } else if(nums[mid] > target){
            lastOcc(nums, target, left, mid - 1);
        } else {
            lastOcc(nums, target, mid + 1, right);
        }
        
    }
    
    public void firstOcc(int[] nums, int target, int left, int right){
        if(left > right){
            return;
        }
        
        int mid = (left + right) / 2;
                
        if(nums[mid] == target){
            first = mid;
            firstOcc(nums, target, left, mid - 1);
        } else if(nums[mid] > target){
            firstOcc(nums, target, left, mid - 1);
        } else {
            firstOcc(nums, target, mid + 1, right);
        }
    }
    
    public int[] searchRange(int[] nums, int target) {
        firstOcc(nums, target, 0, nums.length - 1);
        lastOcc(nums, target, 0, nums.length - 1);
        
        return new int[]{first, last};
    }
}