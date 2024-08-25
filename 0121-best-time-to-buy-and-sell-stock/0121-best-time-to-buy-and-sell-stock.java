class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int left = 0, right = 1;
        
        while(left < prices.length && right < prices.length){
            if(prices[left] >= prices[right]){
                left = right;
            } else{
                res = Math.max(res, prices[right] - prices[left]);
            }
            right++;
        }
        
        return res;
    }
}

/*
[7,1,5,3,6,4]
 l r
 
 l >= r: l = r; r++;
 l < r : res = max(res, num[r] - num[l]); r++;

*/