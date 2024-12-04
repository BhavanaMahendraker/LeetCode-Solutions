class Solution {
    public int uniquePaths(int m, int n) {
        // return solveRec(m, n, 0, 0, new boolean[m][n]);
        
//         int[][] memo = new int[m][n];
//         for(int[] row: memo){
//             Arrays.fill(row, -1);
//         }
//         return solveMem(m, n, 0, 0, new boolean[m][n], memo);
        
        return solveTab(m, n);
    }
    
    private int solveTab(int m, int n){
        int[][] dp = new int[m][n];
        
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        
        for(int i=0; i<n; i++){
            dp[m-1][i] = 1;
        }
        for(int i=0; i<m; i++){
            dp[i][n-1] = 1;
        }
        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                if(dp[i+1][j] != -1 && dp[i][j+1] != -1)
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        
        return dp[0][0];
    }
    
    private int solveMem(int m, int n, int i, int j, boolean[][]visited, int[][] memo){
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j] == true)
            return 0;
        
        if(i == m-1 && j==n-1)
            return 1;
        
        if(memo[i][j] != -1)
            return memo[i][j];
        
        visited[i][j] = true;
        
        memo[i][j] = solveMem(m, n, i+1, j, visited, memo) + solveMem(m, n, i, j+1, visited, memo);
        
        visited[i][j] = false;
        
        return memo[i][j];
    }
    
    // Time Limit Exceeded    
    private int solveRec(int m, int n, int i, int j, boolean[][]visited){
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j] == true){
            return 0;
        }
        if(i == m-1 && j==n-1){
            return 1;
        }
        visited[i][j] = true;
        
        int res = solveRec(m, n, i+1, j, visited) + solveRec(m, n, i, j+1, visited);
        
        visited[i][j] = false;
        
        return res;
    }
}