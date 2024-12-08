class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // return solveRec(text1, text2, 0, 0);
        
        int[][]memo = new int[text1.length()][text2.length()];
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }
        return solveMemo(text1, text2, 0, 0, memo);
    }
    
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
    // SC: O(max(text1Length, text2Length)) This is my guess
    // Time Limit Exceeded
    public int solveRec(String text1, String text2, int i, int j){
        if(i >= text1.length() || j >= text2.length())
            return 0;
        
        if(text1.charAt(i) == text2.charAt(j))
            return 1 + solveRec(text1, text2, i+1, j+1);
        
        return Math.max(solveRec(text1, text2, i+1, j), solveRec(text1, text2, i, j+1));
    }
}