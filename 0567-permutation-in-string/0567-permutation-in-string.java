class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        //TC: O(26 * N), SC: O(26)
        int left = 0;
        HashMap<Character, Integer> freqMapS1 = new HashMap<>();
        HashMap<Character, Integer> freqMapS2 = new HashMap<>();
        
        for(char ch: s1.toCharArray()){
            freqMapS1.put(ch, freqMapS1.getOrDefault(ch, 0)+1);
        }     
        
        for(int right = 0; right < s2.length(); right++){
            if(freqMapS1.equals(freqMapS2))
                return true;
            
            if(right >= s1.length()){
                if(freqMapS2.get(s2.charAt(left)) - 1 <= 0){
                    freqMapS2.remove(s2.charAt(left));
                } else{
                    freqMapS2.put(s2.charAt(left), freqMapS2.get(s2.charAt(left)) - 1);
                }
                left++;
            }
            freqMapS2.put(s2.charAt(right), freqMapS2.getOrDefault(s2.charAt(right), 0) + 1);
        }
        
        return freqMapS1.equals(freqMapS2);
    }
}

/*
eidbaooo
 l
  r

mapS2 =>
e -> 1
i -> 1

mapS1 => 
a -> 1
b -> 1

while r < S2 length
    if(mapS1 == mapS2)
        return true
    r++
    mapS2.put(rightChar, rightCharFreq++)
    if(r >= mapS1.size())
        mapS2.put(leftChar, leftCharFreq--)
        if(leftCharFreq <= 0)
            mapS2.remove(leftChar)
        l++;

return false;


*/