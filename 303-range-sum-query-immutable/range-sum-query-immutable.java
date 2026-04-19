class NumArray {
    int [] numsArr;

    public NumArray(int[] nums) {
        numsArr = new int[nums.length];
        numsArr[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            numsArr[i] = numsArr[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0){
            return numsArr[right];
        }

        return numsArr[right] - numsArr[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */