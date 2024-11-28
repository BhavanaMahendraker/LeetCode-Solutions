class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(dfs(board, word, visited, i, j, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int letterIndex){
        if(letterIndex == word.length())
            return true;
        
        if(i<0 || j<0 || i>=board.length || j>=board[i].length 
           || word.charAt(letterIndex) != board[i][j] || visited[i][j] == true)
            return false;
        
        
        visited[i][j] = true;
        
        boolean ans = dfs(board, word, visited, i+1, j, letterIndex + 1)
                    || dfs(board, word, visited, i-1, j, letterIndex + 1)
                    || dfs(board, word, visited, i, j+1, letterIndex + 1)
                    || dfs(board, word, visited, i, j-1, letterIndex + 1);
        
        visited[i][j] = false;

        return ans;
    }
}