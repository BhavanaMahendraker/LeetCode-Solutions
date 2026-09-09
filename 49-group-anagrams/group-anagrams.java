class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramMap = new HashMap<>();

        for(String str: strs){
            char[] alphabets = new char[26];

            for(char ch: str.toCharArray()){
                alphabets[ch - 'a']++;
            }
            String key = new String(alphabets);
            anagramMap.putIfAbsent(key, new ArrayList<>());
            anagramMap.get(key).add(str);
        }

        return new ArrayList<>(anagramMap.values());

    }
}