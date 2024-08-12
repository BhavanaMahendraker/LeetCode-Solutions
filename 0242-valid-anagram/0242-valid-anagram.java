class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        
        s = new String(sArr);  
        t = new String(tArr);

        
        return s.equals(t);
        
//         if(s.length() != t.length())
//             return false;
        
//         int[] letters = new int[26];
        
//         for(int i=0; i<s.length(); i++){
//             letters[s.charAt(i) - 'a']++;
//             letters[t.charAt(i) - 'a']--;
//         }
        
//         for(int l: letters){
//             if(l != 0)
//                 return false;
//         }
        
//         return true;
        
    }
}