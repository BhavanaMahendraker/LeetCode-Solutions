class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return normalValidPalindrome(s.substring(left+1, right+1))
                || normalValidPalindrome(s.substring(left, right));
            }
            left++;
            right--;
        }
        
        return true;
    }

    private boolean normalValidPalindrome(String s){
        int left = 0, right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}