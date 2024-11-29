class TrieNode{
    char letter;
    TrieNode[] children;
    boolean endOfWord;
    boolean addedToRes;
    
    public TrieNode(char letter){
        this.letter = letter;
        children = new TrieNode[26];
        endOfWord = false;
        addedToRes = false;
    }
} 

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = new TrieNode(' ');
        for(String word: words){
            addWordToTrie(root, word);
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                dfs(board, i, j, root, new StringBuilder(), res);
            }
        }
        
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode root, StringBuilder sb, List<String> res){
        
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] == '*' 
           || root.children[board[i][j] - 'a'] == null){
            return;
        }
        
        char temp = board[i][j];
        board[i][j] = '*';
        
        sb.append(temp);
        root = root.children[temp - 'a'];

        if(root.endOfWord == true && root.addedToRes == false){
            res.add(new String(sb));
            root.addedToRes = true;
        }
        
        dfs(board, i+1, j, root, sb, res);
        dfs(board, i-1, j, root, sb, res);
        dfs(board, i, j+1, root, sb, res);
        dfs(board, i, j-1, root, sb, res);
        
        sb.deleteCharAt(sb.length()-1);
        board[i][j] = temp;        
    }
    
    private void addWordToTrie(TrieNode currNode, String word){
        for(char ch: word.toCharArray()){
            if(currNode.children[ch - 'a'] == null){
                currNode.children[ch - 'a'] = new TrieNode(ch);
            }
            currNode = currNode.children[ch - 'a'];
        }
        currNode.endOfWord = true;
    }
}