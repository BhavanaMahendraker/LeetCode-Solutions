class Solution {
    public long countPairs(int n, int[][] edges) {
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        long[] count = new long[1];
        count[0] = 0;
        long totalPairs = ((long)n)*((long)n-1)/2;
        
        for(int[] edge: edges){
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.putIfAbsent(edge[1], new ArrayList<>());
            
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        for(int i=0; i<n; i++){
            if(!visited.contains(i)){
                count[0] = 0;
                dfs(adj, visited, count, i);
                totalPairs -= count[0]*(count[0] - 1)/2;
            }
        }
        
        return totalPairs;
    }
    
    private void dfs(HashMap<Integer, ArrayList<Integer>> adj, HashSet<Integer> visited,
                      long[] count, int curr){
        visited.add(curr);
        count[0]++;
        for(int neigh: adj.getOrDefault(curr, new ArrayList<>())){
            if(visited.contains(neigh))
                continue;
            dfs(adj, visited, count, neigh);
        }
    }
}