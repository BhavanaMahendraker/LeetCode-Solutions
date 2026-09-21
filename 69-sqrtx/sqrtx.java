class Solution {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }

        int left = 0, right = x, res = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;
            long curr = (long)mid * mid;

            if(curr <= x){
                res = mid;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }

        return res;
    }
}