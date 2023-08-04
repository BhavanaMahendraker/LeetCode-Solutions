class Solution {
    HashSet<Integer> visited = new HashSet<>();
    public boolean canReach(int[] arr, int start) {
        if(start < 0 || start >= arr.length)
            return false;
        
        if(arr[start] == 0)
            return true;
        
        if(visited.contains(start))
            return false;
        
        visited.add(start);
        
        return canReach(arr, start + arr[start]) ||  canReach(arr, start - arr[start]);
    }
}