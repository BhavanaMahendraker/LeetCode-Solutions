class Solution {
    public int missingNumber(int[] nums) {
        /*
        // XOR solution
        int res = nums.length;
        
        for(int i=0; i<nums.length; i++){
            res = res ^ i ^ nums[i];
        }
        
        return res;
        */
        
        // (expected_sum - actual_sum) Soltion
        // expected_sum = n(n+1)/2
        int expected = nums.length * (nums.length + 1) / 2;
        int actual = 0;
        
        for(int num: nums){
            actual += num;
        }
        
        return expected - actual;
    }
}