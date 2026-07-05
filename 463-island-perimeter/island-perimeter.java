class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    res += dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private int dfs(int[][]grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return 1;
        }

        if(grid[i][j] == 2){
            return 0;
        }

        grid[i][j] = 2;

        return dfs(grid, i+1, j) + dfs(grid, i-1, j) + dfs(grid, i, j+1) + dfs(grid, i, j-1);
    }
}