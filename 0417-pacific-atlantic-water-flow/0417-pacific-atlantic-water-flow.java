class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<ArrayList<Integer>> pacific = new HashSet<>();
        HashSet<ArrayList<Integer>> atlantic = new HashSet<>();
        int rows = heights.length, cols = heights[0].length;
        
        // top and bottom rows
        for(int i=0; i<cols; i++){
            possibleCellsDFS(heights, pacific, 0, i, heights[0][i]);
            possibleCellsDFS(heights, atlantic, rows-1, i, heights[rows-1][i]);
        }
        
        // left and right columns
        for(int i=0; i<rows; i++){
            possibleCellsDFS(heights, pacific, i, 0, heights[i][0]);
            possibleCellsDFS(heights, atlantic, i, cols-1, heights[i][cols-1]);
        }
        
        for(ArrayList<Integer> coordinates: pacific){
            if(atlantic.contains(coordinates)){
                res.add(coordinates);
            }
        }
        
        return res;
    }
    
    public void possibleCellsDFS(int[][] heights, HashSet<ArrayList<Integer>> cellsSet, 
                                 int i, int j, int prevHeight){
        //List<Integer> a = List.of(i,j);
        if(i<0 || j<0 || i==heights.length || j==heights[0].length 
           || heights[i][j] <  prevHeight || cellsSet.contains(List.of(i,j)))
            return;
        
        cellsSet.add(new ArrayList(List.of(i,j)));
        
        possibleCellsDFS(heights, cellsSet, i+1, j, heights[i][j]);
        possibleCellsDFS(heights, cellsSet, i-1, j, heights[i][j]);
        possibleCellsDFS(heights, cellsSet, i, j+1, heights[i][j]);
        possibleCellsDFS(heights, cellsSet, i, j-1, heights[i][j]);
    }
}