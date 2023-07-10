class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // TC: O(N), SC: O(K)
        int [][] res = new int[k][2];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));
        for(int[] p : points){
            pq.add(p);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        while(!pq.isEmpty()){
            res[--k] = pq.poll();
        }
        
        return res;        
    }
}