class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Map<Character, Integer> allowedMap = new HashMap<>();
        for (char c : allowed.toCharArray()) {
            allowedMap.put(c, 1);
        }
        Set<Character> allowedSet = allowedMap.keySet();
        
        int count = 0;
        for (String word : words) {
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : word.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            Set<Character> mapSet = map.keySet();
            boolean consistent = true;
            for (char c : mapSet) {
                if (allowedSet.contains(c)) {
                    continue;
                } else {
                    consistent = false;
                    break;
                }
            }
            if (consistent == true) {
                count++;
            }
        }
        return count;
    }
}