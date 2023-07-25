class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adjlist = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        
        for(int[] prereq : prerequisites){
            adjlist.putIfAbsent(prereq[0], new ArrayList<>());
            adjlist.get(prereq[0]).add(prereq[1]);
        }
        
        for(Integer key : adjlist.keySet()){
            if(isCycle(key, adjlist, visited))
                return false;
        }
        
        return true;
    }
    
    public boolean isCycle(int key, HashMap<Integer, ArrayList<Integer>> adjlist, HashSet<Integer> visited){
        if(visited.contains(key))
            return true;
        
        if(adjlist.get(key) == null)
            return false;
        
        visited.add(key);
        
        for(int child : adjlist.get(key)){
            if(isCycle(child, adjlist, visited)){
                return true;
            }
        }
        
        visited.remove(key);
        adjlist.put(key, new ArrayList<>()); // Removes repeated work
        
        return false;        
    }
}