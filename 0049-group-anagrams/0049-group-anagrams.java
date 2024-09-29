class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String str: strs){
            char[] lettersFreq = new char[26];
            
            for(char ch: str.toCharArray()){
                lettersFreq[ch - 'a']++;
            }
            
            String key = new String(lettersFreq);
            
            map.putIfAbsent(key, new ArrayList());
            
            map.get(key).add(str);
        }
        
        return new ArrayList(map.values());
    }
}