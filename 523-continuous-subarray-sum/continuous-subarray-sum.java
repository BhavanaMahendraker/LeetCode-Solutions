class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixModMap = new HashMap<>();
        int runningSum = 0;
        prefixModMap.put(0, -1);
        
        for(int i = 0; i<nums.length; i++){
            runningSum += nums[i];
            int remainder = runningSum % k;
            if(!prefixModMap.containsKey(remainder)){
                prefixModMap.put(remainder, i);
            } else if (i - prefixModMap.get(remainder) > 1){
                return true;
            }
        }

        return false;
    }
}