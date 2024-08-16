class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        
        pq.addAll(freq.entrySet());
        
        int[] res = new int[k];
        for(int i =0; i<k; i++){
            res[i] = pq.poll().getKey();
        }
        
        return res;
    }
}