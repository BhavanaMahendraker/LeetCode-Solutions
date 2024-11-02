class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right =0, maxProfit = 0;
        
        while(right < prices.length){
            if(prices[left] > prices[right]){
                left = right;
            } else{
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
                right++;
            }
        }
        
        return maxProfit;
    }
}

/*
[7,1,5,3,6,4]
   l
           r


if l > r 
  l = r
else
  max = max(max, r - l)

*/