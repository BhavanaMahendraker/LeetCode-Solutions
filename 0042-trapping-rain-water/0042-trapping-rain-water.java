class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftHeights = new int[n];
        int[] rightHeights = new int[n];
        int trappedWater = 0;
        
        for(int i=1; i<n; i++){
            leftHeights[i] = Math.max(height[i-1], leftHeights[i-1]);
        }
        
        for(int i=n-2; i>=0; i--){
            rightHeights[i] = Math.max(height[i+1], rightHeights[i+1]);
        }
        
        for(int i=0; i<n; i++){
            int curr = Math.min(leftHeights[i], rightHeights[i]) - height[i];
            trappedWater += curr < 0 ? 0 : curr;
        }
        
        return trappedWater;
    }
}

/*
[0,1,0,2,1,0,1,3,2,1,2,1]

leftHeightArr
[0,0,1,1,2,2,2,2,3,3,3,3]

rightHeightArr
[3,3,3,3,3,3,3,2,2,2,1,0]


min(leftHeightArr[i], rightHeightArr[i]) - height[i] > 0
*/