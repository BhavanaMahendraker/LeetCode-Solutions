class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramMap = new HashMap<>();

        for(String str: strs){
            int[] alphabets = new int[26];

            for(char ch: str.toCharArray()){
                alphabets[ch - 'a']++;
            }
            String key = Arrays.toString(alphabets);
            anagramMap.putIfAbsent(key, new ArrayList<>());
            anagramMap.get(key).add(str);
        }

        return new ArrayList<>(anagramMap.values());

    }
}