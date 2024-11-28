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
        
        for(int i=wordIndex; i< word.length(); i++){
            if(word.charAt(i) == '.'){
                for(int j=0; j<26; j++){
                    if(curr.children[j] != null && dfsSearch(word, i + 1, curr.children[j])){
                        return true;
                    }
                }
                return false;
            } else {
                if(curr.children[word.charAt(i) - 'a'] == null){
                    return false;
                }
                curr = curr.children[word.charAt(i) - 'a'];
            }
        }
        
        return curr.endOfWord;        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */