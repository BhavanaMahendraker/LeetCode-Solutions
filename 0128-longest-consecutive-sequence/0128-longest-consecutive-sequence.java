class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for(int num: nums)
            set.add(num);
        
        for(int num: nums){
            if(set.contains(num-1))
                continue;
            
            int counter = 0;
                        
            while(set.contains(num)){
                counter++;
                num = num + 1;
            }
            res = Math.max(res, counter);
        }
        
        return res;
    }
}