class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if (word.charAt(0) == board[i][j] && dfs(i,j,board, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word, int wIndex){
        if(wIndex == word.length()){
            return true;
        }

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(wIndex)){
            return false;
        } 

        char temp = board[i][j];
        board[i][j] = '.';

        boolean possible =  dfs(i+1, j, board, word, wIndex + 1) || dfs(i, j+1, board, word, wIndex + 1) 
                    || dfs(i-1, j, board, word, wIndex + 1) || dfs(i, j-1, board, word, wIndex + 1);

        board[i][j] = temp;
        return possible;
    }
}