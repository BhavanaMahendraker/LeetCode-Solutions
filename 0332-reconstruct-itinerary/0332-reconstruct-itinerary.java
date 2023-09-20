class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adjList = new HashMap<>();
        List<String> res = new ArrayList<>();
        
        for(List<String> t : tickets){
            adjList.putIfAbsent(t.get(0), new PriorityQueue<>());
            adjList.get(t.get(0)).add(t.get(1));
        }
        
        dfs("JFK", adjList, res);
        
        return res;        
    }
    
    public void dfs(String curr, HashMap<String, PriorityQueue<String>> adjList, List<String> res){
        while(adjList.containsKey(curr) && !adjList.get(curr).isEmpty()){
            dfs(adjList.get(curr).poll(), adjList, res);
        }
        res.add(0, curr);
    }
}