class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, res = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        
        while(right < s.length()){
            char rightChar = s.charAt(right);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
            
            while((right - left +  1) - Collections.max(freqMap.values()) > k){
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        
        return res;
    }
}

/*
AABABBA
l
  r

map =>
A - 2
B - 1

windowLength = r - l + 1;
map.put(rightChar, freqRightChar++)
while(windowLength - mostFreqElem > k){
    map.put(leftChar, freqLeftChar--);
    left++;
    windowLength = r - l + 1;
}

res = max(res, r - l + 1);

*/