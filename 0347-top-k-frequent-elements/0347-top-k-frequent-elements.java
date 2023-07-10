class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1]; 
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for(int key: freq.keySet()){
            if(bucket[freq.get(key)] == null)
                bucket[freq.get(key)] = new ArrayList<>();
            bucket[freq.get(key)].add(key);
        }
        int pos = 0;
        
        int[] res = new int[k];
        for(int i= bucket.length - 1; i >= 0; i--){
            
            if(bucket[i] != null){
                for(int j=0; j<bucket[i].size() ; j++){
                    res[pos] = bucket[i].get(j);
                    pos++;
                }
                if(pos >= res.length)
                    break;
            }
        }

        return res;
    }
}