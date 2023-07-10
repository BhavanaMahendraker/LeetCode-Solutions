class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0, right = nums.length - 1;
        
        while(left < right){
            int p = left;
            for(int i = left; i < right; i++){
                if(nums[i] < nums[right]){
                    swap(nums, i, p);
                    p++;
                }
            }
            swap(nums, p, right);
            
            if(k < p)
                right = p - 1;
            else if(k > p)
                left = p + 1;
            else
                return nums[p];
        }
        return nums[k];
    }
    
    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}