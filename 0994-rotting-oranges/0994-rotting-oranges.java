class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int timeTaken = 0;
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int totalNumOfFreshOranges = 0;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    totalNumOfFreshOranges++;
                }
            }
        }
        
        if(totalNumOfFreshOranges == 0){
            return 0;
        }
        while(!q.isEmpty()){
            int size = q.size();
            timeTaken++;
            while(size-- > 0){
                int curr[] = q.poll();
                for(int[] dir: dirs){
                    int i=curr[0]+dir[0];
                    int j=curr[1]+dir[1];
                    
                    if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] != 1){
                        continue;
                    }
                    // Mark as visited !!!!!!!!
                    grid[i][j] = 0;
                    totalNumOfFreshOranges--;
                    q.add(new int[]{i,j});
                }
            }
        }
        return totalNumOfFreshOranges == 0 ? timeTaken-1 : -1;
    }
}

/*
[2,1,1],
[1,1,0],
[0,1,1]





dir ={{1,0}, {0,1}, {-1,0}, {0,-1}}
while q not empty
    time++
    size = q.size
    while size > 0
        int []curr = q.poll
        for(dir : dirs)
            i = curr[0] + dir[0]
            j = curr[1] + dir[1]
            if i<0 || j<0 || i>grid.length || j>grid[0].length || grid[i][j] != 1
                continue
            q.add(grid[i][j])
            
    return time

*/