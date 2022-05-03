class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j : routes[i]) {
                if (!map.containsKey(j)) {
                    map.put(j, new HashSet<>());
                }
                map.get(j).add(i);
            }
        }
        
        Queue<int[]> bfs = new ArrayDeque<>();
        bfs.add(new int[]{source, 0});
        Set<Integer> seen = new HashSet<>();
        seen.add(source);
        boolean[] seenRoutes = new boolean[n];
        while (!bfs.isEmpty()) {
            int stop = bfs.peek()[0];
            int bus = bfs.peek()[1];
            bfs.poll();
            if (stop == target) return bus;
            for (int i : map.get(stop)) {
                if (seenRoutes[i]) continue;
                for (int j : routes[i]) {
                    if (!seen.contains(j)) {
                        seen.add(j);
                        bfs.offer(new int[]{j, bus + 1});
                    }
                }
                seenRoutes[i] = true;
            }
        }
        return -1;
    }
}