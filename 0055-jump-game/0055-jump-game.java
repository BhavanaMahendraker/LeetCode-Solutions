class Solution {
    public boolean canJump(int[] nums) {
        boolean [] res = new boolean[nums.length];
        res[nums.length - 1] = true;
        int goal = nums.length - 1;
        
        for(int i=res.length-2; i>=0; i--){
            if(i + nums[i] >= goal){
                goal = i;
            }
            
            // if(i+nums[i] >= goal){
            //     res[i] = true;
            //     goal = i;
            // }
            
            // int jumpLength = nums[i];
            // for(int j=0; j<=Math.min(nums.length, jumpLength); j++){
            //     if(res[i + j] == true){
            //         res[i] = true;
            //         break;
            //     }
            // }
        }
        
        // return res[0];
        return goal == 0;
    }
}