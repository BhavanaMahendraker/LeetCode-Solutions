class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // return solveRec(text1, text2, 0, 0);
        
        // int[][]memo = new int[text1.length()][text2.length()];
        // for(int[] row: memo){
        //     Arrays.fill(row, -1);
        // }
        // return solveMemo(text1, text2, 0, 0, memo);
        
        // return solveTab(text1, text2);
        return solveTabSpaceOptimized(text1, text2);
    }
    
    // Space Optimized
    // TC: O(text1Length * text2Length) This is my guess
    // SC: O(text2Length) This is my guess
    public int solveTabSpaceOptimized(String text1, String text2){
        int[]curr = new int[text2.length() + 1];
        int[]next = new int[text2.length() + 1];
                
        for(int i=text1.length()-1; i>=0; i--){
            for(int j=text2.length()-1; j>=0; j--){
                int ans = 0;
                if(text1.charAt(i) == text2.charAt(j)){
                    ans = 1 + next[j+1];
                } else{
                    ans = Math.max(next[j], curr[j+1]);
                }
                curr[j] = ans;
            }
            
            next = curr;
            curr = new int[text2.length() + 1];
        }
        
        return next[0];
    }
    
    // TC: O(text1Length * text2Length) This is my guess
    // SC: O(text1Length * text2Length) This is my guess
    public int solveTab(String text1, String text2){
        int[][]dp = new int[text1.length() + 1][text2.length() + 1];
                
        for(int i=text1.length()-1; i>=0; i--){
            for(int j=text2.length()-1; j>=0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        
        return dp[0][0];
    }
    
    // TC: O(text1Length * text2Length) This is my guess
    // SC: O(text1Length * text2Length) This is my guess
    public int solveMemo(String text1, String text2, int i, int j, int[][] memo){
        if(i >= text1.length() || j >= text2.length())
            return 0;
        
        if(memo[i][j] != -1)
            return memo[i][j];
        
        if(text1.charAt(i) == text2.charAt(j)){
            memo[i][j] = 1 + solveMemo(text1, text2, i+1, j+1, memo);
            return memo[i][j];
        }
        
        memo[i][j] = Math.max(solveMemo(text1, text2, i+1, j, memo), solveMemo(text1, text2, i, j+1, memo));
        return memo[i][j];
    }
    
    // TC: O(3^(text1Length + text2Length)) This is my guess
    // SC: O(text1Length + text2Length) This is my guess
    // Time Limit Exceeded
    public int solveRec(String text1, String text2, int i, int j){
        if(i >= text1.length() || j >= text2.length())
            return 0;
        
        if(text1.charAt(i) == text2.charAt(j))
            return 1 + solveRec(text1, text2, i+1, j+1);
        
        return Math.max(solveRec(text1, text2, i+1, j), solveRec(text1, text2, i, j+1));
    }
}