class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prefix = 1, postfix = 1;
        int[] res = new int[nums.length];
        
        for(int i=0; i<n; i++){
            res[i] = prefix;
            prefix *= nums[i];
        }
        
        for(int i=n-1; i>=0; i--){
            res[i] *= postfix;
            postfix *= nums[i];
        }
        
        return res;
    }
}

/*
1,2,3,4
    i

prefix = 2 = res[i+1]

res = 1,1,2,6
            i+1

res[i+1] = i * pre; (0-> n-1)


postfix = 6 = res[i]

res = 1,1,2,6
        i
          
1,2,3,4
    i+1

res[i] = nums[i+1]*post;  i: n-2 -> 0
*/