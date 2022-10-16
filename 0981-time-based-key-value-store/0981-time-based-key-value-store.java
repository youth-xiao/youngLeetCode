class TimeMap {

    Map<String, List<Pair<String, Integer>>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());   
        }
        map.get(key).add(new Pair<>(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        
        if (map.containsKey(key)) {
            List<Pair<String, Integer>> list = map.get(key);
            // Collections.sort(list, ((a, b) -> a.getValue() - b.getValue()));
            
            if (timestamp < list.get(0).getValue()) return "";
            
            int left = 0;
            int right = list.size();
            
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid).getValue() <= timestamp) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (right == 0) {
                return "";
            } else {
                return list.get(right - 1).getKey();
            }
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */