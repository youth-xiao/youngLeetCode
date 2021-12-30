class WordDistance {
    
    Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            map.putIfAbsent(word, new ArrayList<>());
            map.get(word).add(i);
        }
        
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        int p1 = 0;
        int p2 = 0;
        int minDistance = Integer.MAX_VALUE;
        
        while (p1 < list1.size() && p2 < list2.size()) {
            minDistance = Math.min(minDistance, Math.abs(list1.get(p1) - list2.get(p2)));
            if (list1.get(p1) > list2.get(p2)) {
                p2++;
            } else {
                p1++;
            }
        }
        
        return minDistance;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */