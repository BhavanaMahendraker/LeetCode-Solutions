public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        int mask = 1;
        
        while(n != 0){
            if((n & 1) == 1)
                res++;
            n = n >>> 1;
        }
                
        return res;
        
        // Explanation:
        // https://leetcode.com/problems/number-of-1-bits/discuss/55099/Simple-Java-Solution-Bit-Shifting
        
        /*
        // TC : O(1), SC: O(1)
        int res = 0;
        
        while(n != 0){
            n &= (n-1);
            res++;
        }
        
        return res;
        */
    }
}