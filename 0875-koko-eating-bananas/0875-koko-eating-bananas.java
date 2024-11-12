class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles){
            right = Math.max(right, pile);
        }
        int minSpeed = right;
        
        while(left <= right){
            int currSpeed = left + (right - left)/2;
            int timeTaken = 0;
            for(int pile: piles){
                timeTaken += Math.ceil((double) pile / currSpeed);
            }
            
            if(timeTaken <= h){
                minSpeed = Math.min(minSpeed, currSpeed);
                right = currSpeed - 1;
            } else{
                left = currSpeed + 1;
            }
        }
        
        return minSpeed;
    }
}