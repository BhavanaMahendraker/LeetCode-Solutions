class Solution {
    public int trap(int[] height) {
        int res = 0;
        
        int[] leftMaxArr = new int[height.length];
        int[] rightMaxArr = new int[height.length];
        
        for(int i=1; i<height.length; i++){
            leftMaxArr[i] = Math.max(leftMaxArr[i-1], height[i-1]);
        }
        
        for(int i=height.length-2; i>=0; i--){
            rightMaxArr[i] = Math.max(rightMaxArr[i+1], height[i+1]);
        }
        
        for(int i=0; i<height.length; i++){
            int currUnits = Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
            if(currUnits > 0)
                res += currUnits;
        }
        return res;
    }
}