class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adjList = new HashMap<>();
        ArrayList<String> res = new ArrayList<String>();
        
        for(List<String> ticket: tickets){
            adjList.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            adjList.putIfAbsent(ticket.get(1), new PriorityQueue<>());
            
            adjList.get(ticket.get(0)).add(ticket.get(1));
        }
        
        dfs(adjList, "JFK", res);
                
        return res;
    }
    
    private void dfs(HashMap<String, PriorityQueue<String>> adjList, String curr, ArrayList<String> res){
        while(!adjList.get(curr).isEmpty()){
            String next = adjList.get(curr).poll();
            dfs(adjList, next, res);
        }
        res.add(0,curr);
    }
}