class Solution {
    public int findDuplicate(int[] nums) {
        /*
        // Solution 1: TC = O(N), SC: O(1)
        for(int i =0; i<nums.length; i++){
            int index = Math.abs(nums[i]);
            if(nums[index] < 0){
                return index;
            }
            nums[index] = -1 * nums[index];
        }
        return -1;
        */
        
        //Solution 2: TC = O(N), SC: O(1)
        // Floyd's Algorithm
        int slow = 0, fast = 0;
        
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
                
        int slow2 = 0;
        
        while(slow != slow2){
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow == slow2)
                break;
        }
        
        return slow;
    }
}