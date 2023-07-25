class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        
        for(int t: time){
            int reducedTime = t % 60;
            int theOther = reducedTime == 0 ? 0 : 60 - reducedTime;
            
            count += freq.getOrDefault(theOther, 0);
            freq.put(reducedTime, freq.getOrDefault(reducedTime, 0) + 1);
        }
        
        return count;
    }
}