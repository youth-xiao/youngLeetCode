class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()); // sort non-increasingly
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        
        Set<Integer> set = new HashSet<>();
        
        int ans = 0;
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> m = pq.poll();
            char c = m.getKey();
            int count = m.getValue();
            while (!set.add(count) && count > 0) {
                count--;
                ans++;
            }
        }
   
        return ans;
    }
}