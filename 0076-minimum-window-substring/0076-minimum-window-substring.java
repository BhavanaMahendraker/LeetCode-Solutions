class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length() || t.length() == 0) 
            return "";

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        int left = 0, have = 0, need = 0;
        int[] res = {Integer.MAX_VALUE, -1, -1};

        for(char ch: t.toCharArray()){
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        need = tMap.size();

        for(int right = 0; right < s.length(); right++){
            char curr = s.charAt(right);
            sMap.put(curr, sMap.getOrDefault(curr, 0) + 1);
            if(tMap.containsKey(curr) && tMap.get(curr).intValue() == sMap.get(curr).intValue()) 
                have++;
            while(have == need){
                if(right - left + 1 < res[0]){
                    res[0] = right - left + 1;
                    res[1] = left;
                    res[2] = right;
                }
                char currLeft = s.charAt(left);
                if(tMap.containsKey(currLeft)){
                    sMap.put(currLeft, sMap.getOrDefault(currLeft, 0) - 1);
                    if(sMap.get(currLeft).intValue() < tMap.get(currLeft).intValue()){
                        have--;
                    }
                }
                left++;
            }
        }

        return res[0] == Integer.MAX_VALUE ? "" : s.substring(res[1], res[2] + 1);
    }
}

/*
ADOBECODEBANC
     l
          r
*/