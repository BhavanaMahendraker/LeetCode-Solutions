class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        ArrayList<String> res = new ArrayList<String>();
        
        dfs(0, s, res, new ArrayList<>(), wordDict);
        return res;
    }
    
    private void dfs(int start, String s, ArrayList<String> res, ArrayList<String> comb, List<String> wordDict){
        if(start == s.length()){
            res.add(new String(String.join(" ", comb)));
        }
        
        for(int end = start; end < s.length(); end++){
            if(!wordDict.contains(s.substring(start, end+1)) ){
                continue;
            }
            
            comb.add(s.substring(start, end+1));
            dfs(end+1, s, res, comb, wordDict);
            comb.remove(comb.size()-1);
        }
    }
}

/*
dfs(0, res, comb, wd)
return res

dfs(start, res, comb, wordDict):
    bc:
    start == length s
        for(str in comb)
            new sentence = str + " "
        
        add comb to res

    int end = start
    
    for(end = start -> length)
        if(s.sub(start, end+1) is in wordDist)
            comb.add(s.sub(start, end+1))
            dfs(end+1, res, comb, wordDict)
            comb.remove(comb.size()-1)
            
    


*/