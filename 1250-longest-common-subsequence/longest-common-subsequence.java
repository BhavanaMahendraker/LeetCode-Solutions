class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // int[][] memo = new int[text1.length()][text2.length()];
        // for(int[] mem : memo){
        //     Arrays.fill(mem, -1);
        // }

        // return dfs(0,0,text1,text2, memo);

        return tabSoln(text1, text2);
        // return tabSolnOptimized(text1, text2);
    }

    private int tabSolnOptimized(String text1, String text2){
        int m = text1.length(), n = text2.length();
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];

        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                } else {
                    curr[j] = Math.max(prev[j], Math.max(curr[j-1], prev[j-1]));
                }
            }
            prev = curr.clone();
        }

        return curr[n];
    }


    private int tabSoln(String text1, String text2){
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        // for(int i=1; i <= m; i++){
        //     for(int j=1; j <= n; j++){
        //         if(text1.charAt(i-1) == text2.charAt(j-1)){
        //             dp[i][j] = 1 + dp[i-1][j-1];
        //         } else {
        //             dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i][j-1], dp[i-1][j-1]));
        //         }
        //     }
        // }

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i][j+1], Math.max(dp[i+1][j], dp[i+1][j+1]));
                }
            }
        }

        return dp[0][0];
    }

    private int dfs(int i, int j, String text1, String text2, int[][] memo){
        if(i==text1.length() || j == text2.length()){
            return 0;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + dfs(i+1, j+1, text1, text2, memo);
        }

        int option1 = dfs(i+1, j, text1, text2, memo);
        int option2 = dfs(i, j+1, text1, text2, memo);
        int option3 = dfs(i+1, j+1, text1, text2, memo);

        memo[i][j] = Math.max(option1, Math.max(option2, option3));

        return memo[i][j];
    }
}