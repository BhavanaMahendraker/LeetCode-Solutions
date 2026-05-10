class Solution {
    private boolean union(int[]parent, int[] rank, int x, int y){
        x = findParent(parent, x);
        y = findParent(parent, y);

        if(x == y){
            return false;
        }

        if(rank[x] >= rank[y]){
            parent[y] = x;
            rank[x] += rank[y];
        } else{
            parent[x] = y;
            rank[y] += rank[x];
        }
        return true;
    }

    private int findParent(int[]parent, int node){
        if(node != parent[node]){
            parent[node] = findParent(parent, parent[node]);
        }
        return parent[node];
    }

    public boolean validTree(int n, int[][] edges) {
        int [] parent = new int[n];
        int [] rank = new int[n];
        int countJoins = 0;
        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge: edges){
            if(!union(parent, rank, edge[0], edge[1])){
                return false;
            }
            countJoins++;
        }

        return countJoins == n-1;
    }
}