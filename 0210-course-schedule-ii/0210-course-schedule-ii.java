class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> dfsVisited = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int[] pre: prerequisites){
            adjList.putIfAbsent(pre[0], new ArrayList<>());
            adjList.putIfAbsent(pre[0], new ArrayList<>());
            
            adjList.get(pre[0]).add(pre[1]);
        }
        
        for(int i=0; i<numCourses; i++){
            if(!visited.contains(i) && isCycle(visited, dfsVisited, adjList, i, res)){
                return new int[0];
            }
        }
        
        return res.stream().mapToInt(i -> i).toArray();
    }
    
    private boolean isCycle(HashSet<Integer> visited, 
                         HashSet<Integer> dfsVisited,
                         HashMap<Integer, ArrayList<Integer>> adjList, 
                         int curr, ArrayList<Integer> res){
        
        dfsVisited.add(curr);
        
        for(int neigh: adjList.getOrDefault(curr, new ArrayList<>())){
            if(dfsVisited.contains(neigh)){
                return true;
            }
            else if(visited.contains(neigh)){
                continue;
            }
            if(isCycle(visited, dfsVisited, adjList, neigh, res)){
                return true;
            }
        }
        
        dfsVisited.remove(curr);
        
        res.add(curr);
        visited.add(curr);
        
        return false;
    }
}