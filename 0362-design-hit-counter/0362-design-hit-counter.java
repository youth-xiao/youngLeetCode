class HitCounter {

    Map<Integer, Integer> map;
    int minTime = -1;
    
    public HitCounter() {
        map = new HashMap<>();
    }
    
    public void hit(int timestamp) {
        map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
        if (timestamp < minTime) minTime = timestamp;
    }
    
    public int getHits(int timestamp) {
        int start = timestamp - 300 + 1;
        if (start < 1) start = 1;
        if (start < minTime) start = minTime;
        int count = 0;
        for (int i = start; i <= timestamp; i++) {
            if (map.containsKey(i)) count += map.get(i);
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */