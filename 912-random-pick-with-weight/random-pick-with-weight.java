class Solution {

    int[] prefixSum;
    int totalSum;

    public Solution(int[] w) {
        prefixSum = new int[w.length];
        totalSum = 0;

        for(int i=0; i<w.length; i++){
            totalSum += w[i];
            prefixSum[i] = totalSum;
        }
    }
    
    public int pickIndex() {
        Random rand = new Random();
        int target = rand.nextInt(totalSum) + 1;

        int left = 0, right = prefixSum.length - 1;
        int res = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(prefixSum[mid] < target){
                left = mid + 1;
            } else{
                res = mid;
                right = mid - 1;
            }
        }

        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */