class TimeMap {

    HashMap<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) 
            return "";
        List<Pair<String, Integer>> list = map.get(key);
        return search(list, timestamp);
    }

    public String search(List<Pair<String, Integer>> list, int timestamp) {
        int start = 0;
        int end = list.size() - 1;
        String res = "";
        while (start <= end) {
            int mid = start + (end - start + 1) / 2;
            if(list.get(mid).getValue() == timestamp)
                return list.get(mid).getKey();
            if (list.get(mid).getValue() < timestamp) {
                start = mid + 1; 
                res = list.get(mid).getKey();
            }
            else 
                end = mid - 1;
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