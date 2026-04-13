class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for(int i=0; i<intervals.length; i++){
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int minRooms = 0, res = 0;
        int i=0, j=0;
        while(i < startTimes.length){
            if(startTimes[i] < endTimes[j]){
                minRooms++;
                i++;
            } else{
                minRooms--;
                j++;
            }
            res = Math.max(res, minRooms);
        }
        
        return res;
    }
}