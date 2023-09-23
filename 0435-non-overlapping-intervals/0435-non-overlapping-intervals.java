class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int remove = 0;
        int[] curr = intervals[0];
        
        for(int i=1; i<intervals.length; i++){
            if(curr[1] <= intervals[i][0]){
                curr = intervals[i];
            } else{
                remove++;
                if(intervals[i][1] < curr[1]){
                    curr = intervals[i];
                }
            }
        }
        
        return remove;
    }
}