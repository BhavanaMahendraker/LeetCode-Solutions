class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        int currSum = 0, res = 0;

        for(int num: nums){
            currSum += num;
            int removeSum = currSum - k;
            res += sumMap.getOrDefault(removeSum, 0);
            sumMap.put(currSum, sumMap.getOrDefault(currSum, 0) + 1);
        }
        return res;
    }
}

/*
k = 3
[1,-1,1,1,1]
          i

currSum = 3
removeSum = 3 - 3 = 0

res = 2

map
0, 2 
1, 2
2, 1



*/