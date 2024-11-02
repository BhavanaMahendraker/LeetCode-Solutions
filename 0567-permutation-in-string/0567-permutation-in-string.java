class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0;
        HashMap<Character, Integer> freqMapS1 = new HashMap<>();
        HashMap<Character, Integer> freqMapS2 = new HashMap<>();
        
        for(char ch: s1.toCharArray()){
            freqMapS1.put(ch, freqMapS1.getOrDefault(ch, 0)+1);
        }     
        
        while(right < s2.length()){
            char rightChar = s2.charAt(right);
            freqMapS2.put(rightChar, freqMapS2.getOrDefault(rightChar, 0) + 1);
            
            if(right >= s1.length()){
                char leftChar = s2.charAt(left);
                if(freqMapS2.get(leftChar) - 1 <= 0){
                    freqMapS2.remove(leftChar);
                } else{
                    freqMapS2.put(leftChar, freqMapS2.get(leftChar) - 1);
                }
                left++;
            }
            right++;
            
            if(freqMapS1.equals(freqMapS2))
                return true;
        }
        
        return false;
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