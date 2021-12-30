class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        queue.addAll(map.values());
        
        int cycles = 0;
        while (!queue.isEmpty()) {
            List<Integer> current = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!queue.isEmpty()) {
                    current.add(queue.remove());
                }
            }
            for (int k : current) {
                if (--k > 0) {
                    queue.add(k);
                }
            }
            
            cycles += queue.isEmpty() ? current.size() : n + 1;
        }
        
        return cycles;
    }
}