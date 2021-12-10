class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.add(new int[]{0, k});
        
        boolean visited[] = new boolean[n + 1];
        int result = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int currNode = curr[1];
            int currDist = curr[0];
            if (visited[currNode]) {
                continue;
            }
            visited[currNode] = true;
            result = currDist;
            n--;
            if (map.containsKey(currNode)) {
                for (int next : map.get(currNode).keySet()) {
                    pq.add(new int[]{currDist + map.get(currNode).get(next), next});
                }
            }
        }
        return n == 0 ? result : -1;
    }
}