class Solution {
    public String longestPalindrome(String s) {
        int[] points = {0,0};
        int start = 0, end = 0, resLen = 0;
        for(int i=0; i<= s.length(); i++){
            helper(s, i, i, points);
            if(resLen == 0 || resLen < points[1]-points[0]+1){
                start = points[0];
                end = points[1];
                resLen = end - start + 1;
            }
            
            helper(s, i, i+1, points);
            if(resLen == 0 || resLen < points[1]-points[0]+1){
                start = points[0];
                end = points[1];
                resLen = end - start + 1;
            }
        }
        
        return s.substring(start, end+1);
    }
    
    public void helper(String s, int left, int right, int[] points){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            points[0] = left;
            points[1] = right;
            left--;
            right++;
        }
    }
}