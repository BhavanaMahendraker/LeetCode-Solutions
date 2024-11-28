class TrieNode{
    char letter;
    TrieNode[] children;
    boolean endOfWord;
    
    public TrieNode(char letter){
        this.letter = letter;
        children = new TrieNode[26];
        endOfWord = false;
    }
}

class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode(' ');
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode(ch);
            }
            curr = curr.children[index];
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        return dfsSearch(word, 0, curr);
    }
    
    private boolean dfsSearch(String word, int wordIndex, TrieNode curr){
        if(wordIndex >= word.length()){
            return curr.endOfWord;
        }
        
        if(curr == null){
            return false;
        }
        
        char ch = word.charAt(wordIndex);
        if(ch == '.'){
            for(TrieNode node: curr.children){
                if(node != null && dfsSearch(word, wordIndex + 1, node)){
                    return true;
                }
            }
            return false;
        } else{
            return curr.children[ch - 'a'] != null 
                && dfsSearch(word, wordIndex + 1, curr.children[ch - 'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */