class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    
    public TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
    }
    
    public void addWord(String word){
        TrieNode curr = this;
        
        for(char ch: word.toCharArray()){
            if(curr.children[ch - 'a'] == null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        
        curr.isEnd = true;
    }
    
    public boolean searchWord(String word){
        TrieNode curr = this;
        
        for(char ch: word.toCharArray()){
            if(curr.children[ch - 'a'] == null){
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        
        return curr.isEnd;
    }
}

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        ArrayList<String> res = new ArrayList<String>();
        TrieNode root = new TrieNode();
        
        for(String word: wordDict){
            root.addWord(word);
        }
        
        dfs(0, s, res, new ArrayList<>(), wordDict, root);
        return res;
    }
    
    private void dfs(int start, String s, ArrayList<String> res, ArrayList<String> comb, List<String> wordDict, TrieNode root){
        if(start == s.length()){
            res.add(new String(String.join(" ", comb)));
        }
        
        for(int end = start; end < s.length(); end++){
            
            String substring = s.substring(start, end+1);
            // if(!wordDict.contains(substring)){
            //     continue;
            // }
            if(!root.searchWord(substring)){
                continue;
            }
            
            comb.add(substring);
            dfs(end+1, s, res, comb, wordDict, root);
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