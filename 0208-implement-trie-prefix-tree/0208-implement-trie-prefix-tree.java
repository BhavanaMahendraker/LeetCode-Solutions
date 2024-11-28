class TrieNode{
    TrieNode[] children;
    boolean endOfWord;
    
    public TrieNode(){
        children = new TrieNode[26];
        endOfWord = false;
    }
}

class Trie {

    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        
        TrieNode curr = root;
        
        for(char ch: word.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        
        for(char ch: word.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index] == null)
                return false;
            curr = curr.children[index];
        }
        
        return curr.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        
        for(char ch: prefix.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index] == null)
                return false;
            curr = curr.children[index];
        }
        
        return true;
    }
}



/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */