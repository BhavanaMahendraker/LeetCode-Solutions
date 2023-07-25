class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int rows = grid.length, cols = grid[0].length, freshOranges = 0, minTime = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        
        if(freshOranges == 0)
            return 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                int[] coords = q.poll();
                for(int[] dir: dirs){
                    int x = coords[0] + dir[0];
                    int y = coords[1] + dir[1];
                    
                    if(x<0 || y<0 || x >= rows || y >= cols || grid[x][y] != 1)
                        continue;
                    
                    grid[x][y] = 2;
                    q.add(new int[]{x,y});
                    freshOranges--;
                }
            }
            minTime++;
        }
        
        return freshOranges != 0 ? -1 : minTime -1;
    }
}