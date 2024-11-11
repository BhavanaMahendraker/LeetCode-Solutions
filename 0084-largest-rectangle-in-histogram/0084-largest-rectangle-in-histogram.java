class Solution {
    public int largestRectangleArea(int[] heights) {
        //startIndex, height
        Stack<int[]> stack = new Stack<>();
        int maxRect = 0;
        
        for(int i=0; i<heights.length; i++){
            int startIndex = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] poppedValue = stack.pop();
                startIndex = poppedValue[0];
                maxRect = Math.max(maxRect, poppedValue[1] * (i - startIndex));
            }
            stack.push(new int[]{startIndex, heights[i]});
        }
        
        while(!stack.isEmpty()){
            int[] poppedValue = stack.pop();
            maxRect = Math.max(maxRect, poppedValue[1] * (heights.length - poppedValue[0]));
        }
        
        return maxRect;
    }
}