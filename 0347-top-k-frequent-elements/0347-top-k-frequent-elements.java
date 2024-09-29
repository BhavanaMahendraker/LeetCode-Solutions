class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        ArrayList<Integer>[] bucketSort = new ArrayList[nums.length + 1];
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        for(int i=0; i<bucketSort.length; i++){
            bucketSort[i] = new ArrayList<>();
        }
        
        for(int key: freqMap.keySet()){
            bucketSort[freqMap.get(key)].add(key);
        }
        
        int[] res = new int[k];
        int l = 0;
        for(int i= bucketSort.length - 1; i>=0 ; i--){
            ArrayList<Integer> currList = bucketSort[i];
            for(int j=0; j<currList.size(); j++){
                if(l < k){
                    res[l] = currList.get(j);
                    l++;
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