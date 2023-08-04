class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int end = intervals[0][1];
        int removed = 0;
        
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] >= end){
                end = intervals[i][1];
            } 
            else{
                removed++;
                end = Math.min(end, intervals[i][1]);
            }
        }
        
        return removed;
    }
}