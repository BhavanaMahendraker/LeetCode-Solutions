class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adjList = new HashMap<>();

        for(List<String> ticket : tickets){
            adjList.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            adjList.get(ticket.get(0)).add(ticket.get(1));
        }

        ArrayList<String> res = new ArrayList<>();
        dfs(adjList, res, "JFK");

        return res;
    }

    private void dfs(HashMap<String, PriorityQueue<String>> adjList, ArrayList<String> res, String curr) {
        while(adjList.containsKey(curr) && !adjList.get(curr).isEmpty()){
            String val = adjList.get(curr).poll();
            dfs(adjList, res, val);
        }
        res.add(0, curr);
    }
}