class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String str : strs){
            
            char[] keyArr = new char[26];
            
            for(char ch : str.toCharArray()){
                keyArr[ch - 'a']++;
            }
            
            String key = new String(keyArr);
            
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            
            map.get(key).add(str);
        }
        
        return new ArrayList(map.values());
    }
}