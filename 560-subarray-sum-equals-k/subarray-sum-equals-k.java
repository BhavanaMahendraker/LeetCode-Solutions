class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCountMap = new HashMap<>();
        prefixCountMap.put(0,1);
        int prefixSum = 0;
        int res = 0;

        for(int num: nums){
            prefixSum += num;
            int complement = prefixSum - k;
            if(prefixCountMap.containsKey(complement)){
                res += prefixCountMap.get(complement);
            }
            prefixCountMap.put(prefixSum, prefixCountMap.getOrDefault(prefixSum, 0) + 1);
        } 

        return res;
    }
}