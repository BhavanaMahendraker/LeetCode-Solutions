class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, ArrayList<String>> adjList = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();

        for (List<String> ticket : tickets) {
            adjList.putIfAbsent(ticket.get(0), new ArrayList<>());
            adjList.putIfAbsent(ticket.get(1), new ArrayList<>());

            adjList.get(ticket.get(0)).add(ticket.get(1));
        }

        // Sort in reverse order
        for (ArrayList<String> destinations : adjList.values()) {
            Collections.sort(destinations, Collections.reverseOrder());
        }

        dfs(adjList, "JFK", res);

        return res;
    }

    private void dfs(
            HashMap<String, ArrayList<String>> adjList,
            String curr,
            LinkedList<String> res) {
        ArrayList<String> destinations = adjList.get(curr);

        while (!destinations.isEmpty()) {
            // Last element is lexicographically smallest
            String next = destinations.remove(destinations.size() - 1);
            dfs(adjList, next, res);
        }

        res.addFirst(curr);
    }
}
