class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        List<int[]> res = new ArrayList<>();
        
        for(int[] interval : intervals){
            if(res.size() == 0){
                res.add(interval);
                continue;
            }
            
            if(interval[0] <= res.get(res.size() - 1)[1]){
                interval[0] = Math.min(interval[0], res.get(res.size() - 1)[0]);
                interval[1] = Math.max(interval[1], res.get(res.size() - 1)[1]);
                res.remove(res.size() - 1);
            }
            res.add(interval);
        }
        
        return res.toArray(new int[res.size()][]);
    }
}