class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        ArrayList<Integer>[] bucketSort = new ArrayList[nums.length + 1];
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        for(int key: freqMap.keySet()){
            int index = freqMap.get(key);
            if(bucketSort[index] == null)
                bucketSort[index] = new ArrayList<>();
            bucketSort[freqMap.get(key)].add(key);
        }
        
        int[] res = new int[k];
        int pos = 0;
        for(int i= bucketSort.length - 1; i>=0 ; i--){
            if(bucketSort[i] != null){
                ArrayList<Integer> currList = bucketSort[i];
                for(int j=0; j<currList.size(); j++){
                    if(pos < k){
                        res[pos] = currList.get(j);
                        pos++;
                    }
                }       
            }
        }
        
        return res;
        
        /*
        // TC: O(klogn), SC: O(n)
        
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
        */
    }
}