class Solution {
    public boolean exist(char[][] board, String word) {
        boolean [][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(dfs(board, word, visited, 0, i, j))
                    return true;
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, boolean[][] visited, int curr, int i, int j){
        if(curr >= word.length())
            return true;
        
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length 
           || board[i][j] != word.charAt(curr) || visited[i][j])
            return false;
        
        visited[i][j] = true;
        
        boolean res =  dfs(board, word, visited, curr+1, i+1, j)
                    || dfs(board, word, visited, curr+1, i-1, j)
                    || dfs(board, word, visited, curr+1, i, j+1)
                    || dfs(board, word, visited, curr+1, i, j-1);
        visited[i][j] = false;
        
        return res;
    }
}