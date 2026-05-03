class Solution {
    public int majorityElement(int[] nums) {
        int element = -1, elementCount = 0;

        for(int num: nums){
            if(elementCount == 0){
                element = num;
            }
            
            if (element != num){
                elementCount--;
            } else {
                elementCount++;
            }
        }

        return element;
    }
}