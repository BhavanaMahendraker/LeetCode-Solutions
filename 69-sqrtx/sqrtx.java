class Solution {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }

        int left = 0, right = x, res = 0;

        while(left <= right){
            long mid = left + (right - left) / 2;
            long curr = mid * mid;

            if(curr <= x){
                res = (int)mid;
                left = (int)mid + 1;
            } else{
                right = (int)mid - 1;
            }
        }

        return res;
    }
}