class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> freqMap.get(b) - freqMap.get(a));
        
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        pq.addAll(freqMap.keySet());
        
        int [] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = pq.poll();
        }
        
        return res;
    }
}