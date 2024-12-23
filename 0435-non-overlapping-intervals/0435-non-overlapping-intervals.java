class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if(intervals.length == 0 || intervals.length == 1){
            return 0; // 0 deletions
        }
        Arrays.sort(intervals, (a,b) ->  {
            return a[0] - b[0];
        });
        
        int totalDeletions = 0;
        int[] prev = intervals[0];
        
        for(int i=1; i<intervals.length; i++){
            int[] curr = intervals[i];
            if(prev[1] <= curr[0]){
                prev = curr;
            } else {
                if(curr[1] < prev[1])
                    prev = curr;
                totalDeletions++;
            }
        }
        
        return totalDeletions;
    }
}