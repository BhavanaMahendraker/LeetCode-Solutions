class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        boolean inserted = false;      
        
        for(int[] currInterval: intervals){
            
            if(inserted == true){
                res.add(currInterval);
                continue;
            }
            
            if(currInterval[1] < newInterval[0]){
                res.add(currInterval);
            } else if(newInterval[1] < currInterval[0]){
                res.add(newInterval);
                res.add(currInterval);
                inserted = true;
            } else{
                int updatedStart = Math.min(newInterval[0], currInterval[0]);
                int updatedEnd = Math.max(newInterval[1], currInterval[1]);
                
                newInterval = new int[]{updatedStart, updatedEnd};
            }
        }
        if(inserted == false){
            res.add(newInterval);
        }
        
        return res.toArray(new int[0][]);
    }
}

/*

if currEnd < newIntervalStart
    add to ansArray
else if newIntervalEnd > currStart 
    add newIntervalEnd
    add curr
    markAsAdded = true

else 
    newStart = min(currStart, newIntervalStart)
    newEnd = min(currEnd, newIntervalEnd)
    newInteval = {newStart, newEnd}


*/