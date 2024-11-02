class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left =0, right = 0, res = 0;
        HashMap<Character, Integer> letterMap = new HashMap<>();
        
        while(right < s.length()){
            char currChar = s.charAt(right);
            if(letterMap.containsKey(currChar)){
                left = Math.max(left, letterMap.get(currChar) + 1);
                letterMap.put(currChar, right);
            }
            letterMap.put(currChar, right);
            res = Math.max(res, right - left + 1);
            right++;
        }
        
        return res;
    }
}

/*
abcabcbb
  l
    r

map=
a => 3
b => 1
c => 2



if(map.containsKey(ch))
    left = map.get(ch) + 1;
    map.put(ch, index)
    
maxlength = max(maxlength, r - l);

TC: O(N), SC: O(N)
*/