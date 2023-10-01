class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxNum = -1;
        HashMap<Integer, Integer> totalPointsMap = new HashMap<>();
                
        for(int num: nums){
            totalPointsMap.put(num, totalPointsMap.getOrDefault(num, 0) + num);
            maxNum = Math.max(maxNum, num);
        }
        
        int[] dp = new int[maxNum + 1];
        dp[0] = totalPointsMap.getOrDefault(0, 0);
        dp[1] = totalPointsMap.getOrDefault(1, 0);
        
        for(int i = 2; i<maxNum + 1; i++){
            dp[i] = Math.max(totalPointsMap.getOrDefault(i, 0) + dp[i-2], dp[i-1]);
        } 
        return dp[dp.length - 1];
    }
}