class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> countPrefixSumMap = new HashMap<>();
        countPrefixSumMap.put(0, 1);
        int currSum = 0;
        int count = 0;
        for(int num: nums){
            currSum += num;
            int complementSum = currSum - k;
            count += countPrefixSumMap.getOrDefault(complementSum, 0);
            countPrefixSumMap.put(currSum, countPrefixSumMap.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}