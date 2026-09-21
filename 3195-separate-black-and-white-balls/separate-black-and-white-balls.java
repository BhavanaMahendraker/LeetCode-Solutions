class Solution {
    public long minimumSteps(String s) {
        int left = 0;
        long res = 0;
        for(int right = 0; right < s.length(); right++){
            if(s.charAt(right) == '0'){
                res += right - left;
                left++;
            }
        }
        return res;
    }
}