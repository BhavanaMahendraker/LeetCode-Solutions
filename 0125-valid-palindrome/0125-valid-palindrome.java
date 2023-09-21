class Solution {
    public boolean isPalindrome(String s) {
        String S = "";
        for(char ch: s.toCharArray()){
            if(Character.isLetterOrDigit(ch))
                S += Character.toLowerCase(ch);
        }
        
        int start = 0, end = S.length() - 1;
        while(start < end){
            if(S.charAt(start) != S.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}