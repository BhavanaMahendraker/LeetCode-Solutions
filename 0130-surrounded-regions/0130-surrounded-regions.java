class Solution {
    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;
        for(int i=0; i<rows; i++){
            if(board[i][0] == 'O')
                convertToTemp(board, i, 0);
            if(board[i][cols - 1] == 'O')
                convertToTemp(board, i, cols - 1);
        }
        
        for(int i=0; i<cols; i++){
            if(board[0][i] == 'O')
                convertToTemp(board, 0, i);
            if(board[rows - 1][i] == 'O')
                convertToTemp(board, rows - 1, i);
        }
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        
        // convert T to O
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void convertToTemp(char[][] board, int i, int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != 'O')
            return;
        
        board[i][j] = 'T';
        
        convertToTemp(board, i+1, j);
        convertToTemp(board, i-1, j);
        convertToTemp(board, i, j+1);
        convertToTemp(board, i, j-1);
    }
}