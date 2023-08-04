class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        Arrays.fill(dp, false);
        dp[s.length()] = true;
        
        for(int i=dp.length - 2; i>=0; i--){
            for(String word: wordDict){
                if(i + word.length() <= s.length() && word.equals(s.substring(i,i+word.length()))){
                    dp[i] = dp[i+word.length()];
                }
                if(dp[i]){
                    break;
                }
            }
        }
        
        return dp[0];
    }
}