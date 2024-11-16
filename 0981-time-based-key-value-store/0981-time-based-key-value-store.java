class TimeMap {
    
    // TC: set() -> O(1), get() -> O(logN)
    // SC: O(M*N)
    // Where N is the total number of values associated with a key and M is the total number of keys.
    
    HashMap<String, ArrayList<Pair<Integer, String>>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)){
            timeMap.put(key, new ArrayList<>());
        }
        
        timeMap.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        
        if(!timeMap.containsKey(key))
            return res;
        
        int left = 0, right = timeMap.get(key).size() - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(timeMap.get(key).get(mid).getKey() <= timestamp){
                res = timeMap.get(key).get(mid).getValue();
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */