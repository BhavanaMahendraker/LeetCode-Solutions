class Solution {
    public int countValidSelections(int[] nums) {
        int leftSum = 0, totalSum = 0, res = 0;

        for(int num: nums){
            totalSum += num;
        }

        for(int num: nums){
            if(num == 0){
                int rightSum = totalSum - leftSum;
                if(rightSum == leftSum){
                    res += 2;
                } else if (Math.abs(rightSum - leftSum) == 1){
                    res += 1;
                }
            }
            leftSum += num;
        }

        return res;
    }
}