class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> alphabetIndexMap = new HashMap<>();

        for(int i=0; i<order.length(); i++){
            alphabetIndexMap.put(order.charAt(i), i);
        }

        for(int i=0; i<words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i+1];

            if(word1.equals(word2)){
                continue;
            }

            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return false;
            }
            
            int j=0;
            while(j < word1.length() && j<word2.length() && word1.charAt(j) == word2.charAt(j)){
                j++;
            }

            if (j < word1.length() && j < word2.length()) {
                if (alphabetIndexMap.get(word1.charAt(j)) > alphabetIndexMap.get(word2.charAt(j))) {
                    return false;
                }
            }
        }

        return true;
    }
}