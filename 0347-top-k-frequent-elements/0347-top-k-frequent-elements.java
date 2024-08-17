class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        ArrayList<Integer>[] bucket = new ArrayList[nums.length +1];
                
        for(Integer key: freq.keySet()){
            int index = freq.get(key);
            if(bucket[index] == null)
                bucket[index] = new ArrayList<>();
            bucket[freq.get(key)].add(key);
        }
        
        int [] res = new int[k];
        int pos = 0;
        
        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
                for(int j=0; j < bucket[i].size(); j++){
                    if(pos < k){
                        res[pos] = bucket[i].get(j);
                        pos++;
                    }
                }
            }
        }
        
        return res;
        
        /*
        // TC: O(nlogn)
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> freq.get(b) - freq.get(a));
        pq.addAll(freq.keySet());
        
        int[] res = new int[k];
        for(int i =0; i<k; i++){
            res[i] = pq.poll();
        }
        
        return res;
        */
    }
}