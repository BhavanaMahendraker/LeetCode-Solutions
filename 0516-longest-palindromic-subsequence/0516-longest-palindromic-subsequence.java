class Solution {
    
    // NOTE: Answer from 1143. Longest Common Subsequence
    
    
    
    public int longestPalindromeSubseq(String s) {
        // return solveRec(text1, text2, 0, 0);
        
        // int[][]memo = new int[text1.length()][text2.length()];
        // for(int[] row: memo){
        //     Arrays.fill(row, -1);
        // }
        // return solveMemo(text1, text2, 0, 0, memo);
        
        // return solveTab(text1, text2);
        // return solveTabSpaceOptimized(text1, text2);
        
        String reverseS = new StringBuilder(s).reverse().toString();
        
        return solveTabFurtherOptimized(s, reverseS);
    }
    
    // Further Space Optimized (Look At This Once!)
    // TC: O(text1Length * text2Length) This is my guess
    // SC: O( min(text1Length, text2Length) ) This is my guess
    public int solveTabFurtherOptimized(String text1, String text2){
        
        // NOTE: minimize space by swapping text2 with text1
        if(text2.length() > text1.length()){
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }
        
        int[]next = new int[text2.length() + 1];
                
        for(int i=text1.length()-1; i>=0; i--){
            // Define curr array inside loop so no need to re-initialize
            int[]curr = new int[text2.length() + 1];
            
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
            // No need to re-initialize
            // curr = new int[text2.length() + 1];
        }
        
        return next[0];
    }
    
}