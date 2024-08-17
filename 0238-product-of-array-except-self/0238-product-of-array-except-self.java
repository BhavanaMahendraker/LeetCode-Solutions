class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftArr = new int[n];
        int[] rightArr = new int[n];
        leftArr[0] = rightArr[nums.length-1] = 1;
        
        for(int i=0; i<n-1; i++){
            leftArr[i+1] = nums[i] * leftArr[i];
        }
        
        for(int i=n-1; i>0; i--){
            rightArr[i-1] = nums[i] * rightArr[i];
        }
     
        for(int i=0; i<n; i++){
            rightArr[i] = leftArr[i] * rightArr[i];
        }
        
        
        
        return rightArr;
    }
}


/*
[1,2,3,4]
 i
[1,1,2,6] 
       j
       
[24,12,4,1]
       k

 (j - 1) * i => j=i+1
 (k+1) * i
*/