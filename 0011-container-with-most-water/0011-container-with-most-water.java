class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        
        while(left < right){
            int currArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currArea);
            
            if(height[left] < height[right]){
                left++;
            } else{
                right--;
            }
        }
        
        return maxArea;
    }
}

/*

lesser height update

*/