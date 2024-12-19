class Solution {
    public String crackSafe(int n, int k) {
        return dfs(new HashSet<>(), new StringBuilder(), n, k, Math.pow(k, n));
    }
    
    private String dfs(HashSet<String> visited, StringBuilder comb, int n, int k, double totalNumComb){
        
        if(comb.length() >= n && visited.contains(comb.substring(comb.length() - n))){
            return "";
        }
        
        if(comb.length() >= n){
            visited.add(comb.substring(comb.length() - n));
        }
        
        // NOTE: The answer will ALWAYS be MINIMUM
        // Because we are skipping any comb that is already visited
        if(visited.size() == totalNumComb){
            return comb.toString();
        }
        
        for(int i=0; i<k; i++){
            comb.append(i);
            String ans = dfs(visited, comb, n, k, totalNumComb);
            if(ans.length() != 0)
                return ans;
            comb.deleteCharAt(comb.length() - 1);
        }
        
        if(comb.length() >= n)
            visited.remove(comb.substring(comb.length() - n));
        
        return "";
    }
}

/*
n = 2

*/