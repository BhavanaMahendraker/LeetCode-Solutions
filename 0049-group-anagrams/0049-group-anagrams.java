class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // TC: O(mn), SC: O(m+n)
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String str: strs){
            int [] countArr = new int[26];
            
            for(char ch: str.toCharArray()){
                countArr[ch - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            for(int count: countArr){
                sb.append('#').append(count);
            }
            String key = sb.toString();
            if(!map.containsKey(key)){
                map.put(key, new ArrayList());
            }
            
            map.get(key).add(str);
        }
        
        return new ArrayList(map.values());
    }
}