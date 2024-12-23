class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1 || intervals.length == 0){
            return intervals;
        }
        
        ArrayList<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int[] prev = intervals[0];
        for(int i=1; i<intervals.length; i++){
            int[] curr = intervals[i];
            if(prev[1] < curr[0]){
                res.add(prev);
                prev = curr;
            }
            else if(prev[1] >= curr[0]){
                // update end
                prev[1] = Math.max(curr[1], prev[1]);
            }
        }
        
        res.add(prev);
        
        return res.toArray(new int[0][]);
    }
}
/*


*/