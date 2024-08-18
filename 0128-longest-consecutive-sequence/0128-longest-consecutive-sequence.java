class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        
        for(int num: nums){
            set.add(num);
        }
        
        for(int num: nums){
            if(set.contains(num-1))
                continue;
            
            int count = 1;
            while(set.contains(++num)){
                count++;
            }
            res = Math.max(res, count);
        }
        
        return res;
    }
}