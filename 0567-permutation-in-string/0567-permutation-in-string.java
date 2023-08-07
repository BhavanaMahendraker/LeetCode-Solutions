class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> newMap = new HashMap<>();
        int left =0;

        for(int right = 0; right <s1.length(); right++){
            map.put(s1.charAt(right), map.getOrDefault(s1.charAt(right), 0) + 1);
        }

        for(int right = 0; right < s2.length(); right++){
            if(map.equals(newMap)) return true;
            if(right >= s1.length()){
                int decrement = newMap.get(s2.charAt(left)) -1;
                if (decrement <= 0)
                    newMap.remove(s2.charAt(left));
                else
                    newMap.put(s2.charAt(left), newMap.get(s2.charAt(left)) -1);
                left++;
            }
            newMap.put(s2.charAt(right), newMap.getOrDefault(s2.charAt(right), 0) + 1);
        }
        if(map.equals(newMap)) return true;

        return false;
    }
}