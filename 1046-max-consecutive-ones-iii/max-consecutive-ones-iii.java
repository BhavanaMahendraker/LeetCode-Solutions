class Solution {
    public int longestOnes(int[] nums, int k) {
        int resLen = 0, left = 0;
        for(int right = 0; right < nums.length; right++){
            k -= nums[right] == 0 ? 1 : 0;

            while(k < 0){
                k += nums[left] == 0 ? 1 : 0;
                left++;
            }
            resLen = Math.max(resLen, right - left + 1);
        }

        return resLen;
    }
}