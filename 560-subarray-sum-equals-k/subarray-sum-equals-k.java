class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        int currSum = 0, res = 0;
        prefixSumCount.put(0, 1);

        for(int num: nums){
            currSum += num;
            int complementSum = currSum - k;
            res += prefixSumCount.getOrDefault(complementSum, 0);
            prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
        }

        return res;
    }
}