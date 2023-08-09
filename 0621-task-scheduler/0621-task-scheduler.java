class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        Queue<int[]> q = new LinkedList<>();
        int[] freqArr = new int[26];
        int time = 0;
        
        for(char ch: tasks){
            freqArr[ch - 'A']++;
        }
        
        for(int freq: freqArr){
            if(freq > 0)
                pq.add(freq);
        }
        
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int val = pq.poll();
                val--;
                if(val > 0)
                    q.add(new int[]{val, time + n});
            }
            
            if(!q.isEmpty() && q.peek()[1] == time){
                pq.add(q.poll()[0]);
            } 
        }
        
        return time;
    }
}