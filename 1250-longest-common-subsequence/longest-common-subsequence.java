class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // int[][] memo = new int[text1.length()][text2.length()];
        // for(int[] mem : memo){
        //     Arrays.fill(mem, -1);
        // }

        // return dfs(0,0,text1,text2, memo);

        return tabSoln(text1, text2);
    }

    private int tabSoln(String text1, String text2){
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for(int i=1; i <= text1.length(); i++){
            for(int j=1; j <= text2.length(); j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }

        return dp[text1.length()][text2.length()];
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