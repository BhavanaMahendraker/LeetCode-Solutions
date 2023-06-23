class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        
        for(int pile: piles){
            right = Math.max(right, pile);
        }
        int res = right;
        
        while(left <= right){
            int speed = (left + right) / 2;
            int hours = 0;
            for(int pile: piles){
                hours += Math.ceil((double) pile / speed);
            }
            if(hours <= h){
                res = Math.min(res, speed);
                right = speed - 1;
            }
            else{
                left = speed + 1;
            }
        }
        return res;
    }
}
