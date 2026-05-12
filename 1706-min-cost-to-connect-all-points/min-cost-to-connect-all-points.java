class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashSet<Integer> visited = new HashSet<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        minHeap.add(new int[]{0,0});
        int total = 0;
        
        while(!minHeap.isEmpty() && visited.size() != points.length){
            int[] curr = minHeap.poll();
            int currIndex = curr[0];
            int weight =  curr[1];
            if(visited.contains(currIndex)){
                continue;
            }

            visited.add(currIndex);
            total += weight;

            for(int neigh=0; neigh<points.length; neigh++){
                if(visited.contains(neigh)){
                    continue;
                }

                int dist = Math.abs(points[currIndex][0] - points[neigh][0]) 
                + Math.abs(points[currIndex][1] - points[neigh][1]);

                minHeap.add(new int[]{neigh, dist});
            }
        }

        return total;
    }
}