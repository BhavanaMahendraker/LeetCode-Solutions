class Solution {
    public int maxFrequency(int[] nums, int k) {
        int left = 0, right = 0, maxFreq = 0;
        long total = 0; 
        Arrays.sort(nums);

        while(right < nums.length){
            total += nums[right];
            while(((long)nums[right]) * (right - left + 1) > total + k){
                total -= nums[left];
                left++;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
            right++;
        }

        return maxFreq;
    }
}