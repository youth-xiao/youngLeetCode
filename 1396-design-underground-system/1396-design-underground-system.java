class UndergroundSystem {
    
    Map<Integer, Pair<String, Integer>> checkInMap = new HashMap<>();
    Map<String, Pair<Double, Double>> travelMap = new HashMap<>();

    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> in = checkInMap.get(id);
        String startStation = in.getKey();
        Integer startTime = in.getValue();
        String stationPair = startStation + "->" + stationName;
        Pair<Double, Double> record = travelMap.getOrDefault(stationPair, new Pair<>(0.0, 0.0));
        Integer tripTime = t - startTime;
        Double totalTravelTime = record.getKey();
        Double totalTrips = record.getValue();
        travelMap.put(stationPair, new Pair<>(totalTravelTime + tripTime, totalTrips + 1));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String searchKey = startStation + "->" + endStation;
        Pair<Double, Double> record = travelMap.get(searchKey);
        Double totalTime = record.getKey();
        Double totalTrips = record.getValue();
        Double averageTime = totalTime / totalTrips;
        return averageTime;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */