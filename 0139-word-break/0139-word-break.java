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
    /*
    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        HashSet<Integer> visited = new HashSet<>();
        
        while(!queue.isEmpty()){
            int start = queue.poll();
            
            if(visited.contains(start)) 
                continue;
            for(int end = start+1; end <= s.length(); end++){
                String sub = s.substring(start, end);
                if(wordDict.contains(sub)){
                    if(end == s.length()) return true;
                    queue.add(end);
                }
            }
            
            visited.add(start);
        }
        return false;        
    }
    */
}