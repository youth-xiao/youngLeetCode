class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, List<Integer>> map = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        int bulls = 0;
        int cows = 0;
        
        for (int i = 0; i < guess.length(); i++) {
            char ch = guess.charAt(i);
            if (map.containsKey(ch)) {
                if (map.get(ch).contains(i)) {
                    bulls++;
                    count.put(ch, count.get(ch) - 1);
                }
            }
        }
        
        for (int i = 0; i < guess.length(); i++) {
            char ch = guess.charAt(i);
            if (map.containsKey(ch)) {
                if (!map.get(ch).contains(i)) {
                    if (count.get(ch) > 0) {
                        cows++;
                        count.put(ch, count.get(ch) - 1);
                    }
                }
            }
        }

        
        sb.append(bulls).append('A').append(cows).append('B');
        return sb.toString();
        
    }
}