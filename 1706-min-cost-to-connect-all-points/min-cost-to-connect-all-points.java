class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashSet<Integer> visited = new HashSet<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        minHeap.add(new int[]{0,0});
        int total = 0;
        
        while(!minHeap.isEmpty() && visited.size() != points.length){
            int[] curr = minHeap.poll();
            int nodeIndex = curr[0];
            int weight =  curr[1];
            if(visited.contains(nodeIndex)){
                continue;
            }

            visited.add(nodeIndex);
            total += weight;

            for(int neigh=0; neigh<points.length; neigh++){
                if(visited.contains(neigh)){
                    continue;
                }

                int[] p1 = points[nodeIndex];
                int[] p2 = points[neigh];

                int dist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);

                minHeap.add(new int[]{neigh, dist});
                minHeap.add(new int[]{nodeIndex, dist});
            }
        }

        return total;
    }
}