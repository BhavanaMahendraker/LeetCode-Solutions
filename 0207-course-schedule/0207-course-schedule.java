class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> dfsVisited = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        
        for(int[] pre: prerequisites){
            adjList.putIfAbsent(pre[0], new ArrayList<>());
            adjList.get(pre[0]).add(pre[1]);
        }
        
        for(int i=0; i<numCourses; i++){
            if(!visited.contains(i)){
                if(isCycle(adjList, i, visited, dfsVisited)){
                    return false;
                }
            }
        }
        return true;
    }
    
    
    private boolean isCycle(HashMap<Integer, ArrayList<Integer>> adjList, int curr, HashSet<Integer> visited, HashSet<Integer> dfsVisited){
        if(dfsVisited.contains(curr)){
            return true;
        }
        
        dfsVisited.add(curr);
        
        for(int neigh: adjList.getOrDefault(curr, new ArrayList<>())){
            if(!visited.contains(neigh) && isCycle(adjList, neigh, visited, dfsVisited))
                return true;
        }
        
        dfsVisited.remove(curr);
        visited.add(curr);

        
        return false;
    }
}






