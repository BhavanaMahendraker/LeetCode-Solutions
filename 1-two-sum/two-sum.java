class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seenMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if(seenMap.containsKey(complement)){
                return new int[]{seenMap.get(complement), i};
            }

            seenMap.put(nums[i], i);
        }

        return new int[]{-1,-1};
    }
}