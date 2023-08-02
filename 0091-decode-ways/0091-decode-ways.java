class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(s, 0, memo);
    }
    
    public int dfs(String s, int start, int[] memo){
        if(start == s.length())
            return 1;
        if(s.charAt(start) == '0')
            return 0;
        
        if(memo[start] != -1)
            return memo[start];
        
        memo[start] = dfs(s, start+1, memo);
        if(start+1 < s.length() && Integer.valueOf(s.substring(start, start+2)) <= 26)
            memo[start] += dfs(s, start + 2, memo);
        
        return memo[start];
    }
}