class TrieNode{
    char ch;
    TrieNode[] children;
    boolean endOfWord;
    
    public TrieNode(char ch){
        this.ch = ch;
        children = new TrieNode[26];
        endOfWord = false;
    }
}

class Trie {
    TrieNode root;
    
    public Trie() {
        root = new TrieNode(' ');
    }
    
    public void insert(String word) {
        TrieNode node = root;
        
        for(char letter: word.toCharArray()){
            if(node.children[letter - 'a'] == null){
                node.children[letter - 'a'] = new TrieNode(letter);
            }
            node = node.children[letter - 'a'];
        }
        node.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        
        for(char letter: word.toCharArray()){
            if(node.children[letter - 'a'] == null){
                return false;
            }
            node = node.children[letter - 'a'];
        }
        return node.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        
        for(char letter: prefix.toCharArray()){
            if(node.children[letter - 'a'] == null){
                return false;
            }
            node = node.children[letter - 'a'];
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