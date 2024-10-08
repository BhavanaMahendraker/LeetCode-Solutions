class Solution {
    public void helper(char[] s, int left, int right){
        
        if(left > right)
            return;
        
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        
        left++; 
        right--;
        
        helper(s, left, right);
    }
    
    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }
}