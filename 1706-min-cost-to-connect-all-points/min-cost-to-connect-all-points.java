class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashMap<Integer, ArrayList<int[]>> adjList = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                int[] p1 = points[i];
                int[] p2 = points[j];
                adjList.putIfAbsent(i, new ArrayList<>());
                adjList.putIfAbsent(j, new ArrayList<>());

                int dist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);

                adjList.get(i).add(new int[]{j, dist});
                adjList.get(j).add(new int[]{i, dist});
            }
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        minHeap.add(new int[]{0,0});
        int total = 0;
        
        while(!minHeap.isEmpty() && visited.size() != points.length){
            int[] curr = minHeap.poll();
            int node = curr[0];
            int weight =  curr[1];
            if(visited.contains(node)){
                continue;
            }

            visited.add(node);
            total += weight;

            for(int[] neigh: adjList.getOrDefault(node, new ArrayList<>())){
                minHeap.add(neigh);
            }
        }

        return total;
    }
}