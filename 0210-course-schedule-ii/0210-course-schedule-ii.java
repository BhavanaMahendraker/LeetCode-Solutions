class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> dfsVisited = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        ArrayList<Integer> topoSort = new ArrayList<>();
        
        // AdjList
        for(int[] pre: prerequisites){
            adjList.putIfAbsent(pre[0], new ArrayList<>());
            adjList.get(pre[0]).add(pre[1]);
        }
        
        // Topological Sort
        for(int i=0; i<numCourses; i++){
            if(!visited.contains(i)){
                if(isCycle(visited, dfsVisited, adjList, i, topoSort)){
                    return new int[0];
                }
            }
        }

        int[] res = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            res[i] = topoSort.get(i);
        }
        
        return res;
    }
    
    private boolean isCycle(HashSet<Integer> visited, 
                         HashSet<Integer> dfsVisited,
                         HashMap<Integer, ArrayList<Integer>> adjList, 
                         int curr, ArrayList<Integer> topoSort){
        
        dfsVisited.add(curr);
        visited.add(curr);
        
        for(int neigh: adjList.getOrDefault(curr, new ArrayList<>())){
            if(!visited.contains(neigh)){
                if(isCycle(visited, dfsVisited, adjList, neigh, topoSort)){
                    return true;
                }
            } else if(/*visited.contains(neigh) &&*/ dfsVisited.contains(neigh)){
                return true;
            }
        }
        
        dfsVisited.remove(curr);
        topoSort.add(curr);
        
        return false;
    }
}