class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // TC: O(mn), SC: O(m+n)
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String str: strs){
            char [] countArr = new char[26];
            
            for(char ch: str.toCharArray()){
                countArr[ch - 'a']++;
            }
            
            String key = String.valueOf(countArr);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        
        return new ArrayList(map.values());
    }
}