class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left =0, right = 0, res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(right < s.length()){
            char currChar = s.charAt(right);
            if(map.containsKey(currChar)){
                left = Math.max(left, map.get(currChar) + 1);
                map.put(currChar, right);
            }
            map.put(currChar, right);
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