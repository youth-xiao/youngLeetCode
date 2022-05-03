class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        // 这个map的作用就是记录 哪几个bus会停靠某个站点
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j : routes[i]) {
                if (!map.containsKey(j)) {
                    map.put(j, new HashSet<>()); // 这里用set还是list都可以 因为题目说了 保证每个bus不含有重复的数字
                }
                map.get(j).add(i); // j是站点 i是array里第几个bus
            }
        }
        
        Queue<int[]> bfs = new ArrayDeque<>();
        bfs.add(new int[]{source, 0}); // 添加起点
        Set<Integer> seen = new HashSet<>(); // 这是记录某个站点有没有被遍历过 - smaller scope
        seen.add(source);
        boolean[] seenRoutes = new boolean[n]; // 这是记录该bus有没有被遍历过 - larger scope
        
        while (!bfs.isEmpty()) { // 一层层遍历 看能不能到target
            int stop = bfs.peek()[0]; // 站点
            int bus = bfs.peek()[1]; // 搭乘了几辆公车
            bfs.poll();
            if (stop == target) return bus;
            for (int i : map.get(stop)) { // map.get(stop) 是看哪几路公车会经过这个stop
                // 所以 这里的i是某路公车
                if (seenRoutes[i]) continue; // 这表示这路公车的信息已经加入bfs里了
                for (int j : routes[i]) { // 遍历这路公车所经过的站台
                    if (!seen.contains(j)) { // 如果该站台还没处理过 则加进bfs里
                        seen.add(j);
                        bfs.offer(new int[]{j, bus + 1}); // 每加一个站台进bfs 增加所搭乘的公车的数量by 1
                    }
                }
                seenRoutes[i] = true;
            }
        }
        return -1;
    }
}