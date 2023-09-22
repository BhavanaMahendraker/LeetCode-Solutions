class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int[] currInterval = intervals[0];
        
        for(int i=1; i<intervals.length; i++){
            if(currInterval[1] < intervals[i][0]){
                ans.add(currInterval);
                currInterval = intervals[i];
            } 
            else {
                currInterval[1] = Math.max(currInterval[1], intervals[i][1]);
            }
        }
        
        ans.add(currInterval);
        return ans.toArray(new int[ans.size()][2]);
    }
}