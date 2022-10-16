class Solution {
    public String getHint(String secret, String guess) {
        // this map records the index of each digit
        Map<Character, List<Integer>> map = new HashMap<>();
        // this map records the count of each digit regardless of positions
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            // record position
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
            // increment count
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        int bulls = 0;
        int cows = 0;
        
        // One trick is to find all bulls before searching for any cows
        // because we want to make sure to handle duplicates properly
        // if we don't do in this way, we may over-count the number of cows
        // also, we count bulls before counting cows b/c it's easier to spot bulls
        for (int i = 0; i < guess.length(); i++) {
            char ch = guess.charAt(i);
            if (map.containsKey(ch)) {
                if (map.get(ch).contains(i)) {
                    bulls++;
                    // we need to decrement once found a bull, to make sure not over-counting
                    count.put(ch, count.get(ch) - 1);
                }
            }
        }
        
        // now all counter of digits remaining are eligible for searching cows
        // since we have eliminated all possible bulls in the previous step
        for (int i = 0; i < guess.length(); i++) {
            char ch = guess.charAt(i);
            if (map.containsKey(ch)) {
                // this means the current ch is not corresponded with the correct position as expected in the 'secret' string, so it could be a cow
                if (!map.get(ch).contains(i)) {
                    // it can be a cow only if there are still counter for the digit based on the 'map' (positive)
                    if (count.get(ch) > 0) {
                        cows++;
                        count.put(ch, count.get(ch) - 1); // also need decrement in case of over-estimation
                    }
                }
            }
        }
        
        // sb.append(bulls).append('A').append(cows).append('B');
        // return sb.toString();
        return bulls + "A" + cows + "B";
    }
}