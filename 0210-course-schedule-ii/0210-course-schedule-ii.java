class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Topo sort Kahn's Algorithm
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        
        for(int[] pre: prerequisites){
            adjList.putIfAbsent(pre[0], new ArrayList<>());
            adjList.putIfAbsent(pre[1], new ArrayList<>());

            adjList.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
        }
        
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0)
                q.add(i);
        }
        
        int pos = numCourses-1;
        int count =0;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            
            for(int neigh: adjList.getOrDefault(curr, new ArrayList<>())){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.add(neigh);
                }
            }
            count++;
            res[pos--] = curr;
        }
        
        return count == numCourses ? res : new int[]{};
    }
}