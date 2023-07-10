class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int stone: stones){
            pq.add(stone);
        }
        
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            int diff = first - second;
            if(diff > 0)
                pq.add(diff);
        }
        
        return pq.size() == 1 ? pq.poll() : 0;
    }
}