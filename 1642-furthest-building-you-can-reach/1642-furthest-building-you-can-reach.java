class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> bricksUsedHeap = new PriorityQueue<>((a,b) -> b-a);
        int i = 0;
        for(i=1; i<heights.length; i++){
            int heightDiff = heights[i] - heights[i-1];
            
            if(heightDiff <= 0){
                continue;
            }

            bricks -= heightDiff;
            bricksUsedHeap.add(heightDiff);
            
            if(bricks < 0){
                if(ladders == 0)
                    return i-1;
                ladders-=1;
                bricks += bricksUsedHeap.poll();
            }
        }
        
        return i-1;
    }
}