class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int multiplier = 1;
        for(int i=0; i<res.length; i++){
            res[i] = multiplier;
            multiplier *= nums[i];
        }
        multiplier = 1;
        for(int i=res.length-1; i>=0; i--){
            res[i] *= multiplier;
            multiplier *= nums[i];
        }

        return res;
    }
}

/*




[1,2,3,4] 
     i

[1,1,8,6]

multiplier = 1 * 4 = 4
res[i] *= multipler
multiplier *= nums[i]

[24,12,4,1]

[24,12,8,6]

*/