class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        // f[t][i]: represents the minimum cost flying from 'src' to city 'i' via 't' flights
        int[][] f = new int[k + 2][n];
        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(f[i], INF);
        }
        f[0][src] = 0;
        for (int t = 1; t <= k + 1; t++) {
            for (int[] flight : flights) {
                int j = flight[0];
                int i = flight[1];
                int cost = flight[2]; // this is the cost flying from 'j' to 'i'
                // f[t][i] on left: minimum cost flying from 'src' to city 'i' via 't' flights
                // f[t - 1][j]: minimum cost flying from 'scr' to city 'j' via 't - 1' flights
                f[t][i] = Math.min(f[t][i], f[t - 1][j] + cost);
            }
        }
        int ans = INF;
        for (int t = 1; t <= k + 1; t++) {
            ans = Math.min(ans, f[t][dst]);
        }
        return ans == INF ? - 1: ans;
    }
}


// TLE
// class Solution {
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         int[][] graph = new int[n][n];
//         for (int[] flight : flights) {
//             graph[flight[0]][flight[1]] = flight[2];
//         }
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
//         pq.offer(new int[] {0, src, k + 1});
//         while (!pq.isEmpty()) {
//             int[] curr = pq.poll();
//             int cost = curr[0];
//             int city = curr[1];
//             int stops = curr[2];
//             if (city == dst) return cost;
//             if (stops > 0) {
//                 for (int i = 0; i < n; i++) {
//                     if (graph[city][i] > 0) {
//                         pq.offer(new int[] {cost + graph[city][i], i, stops - 1});
//                     }
//                 }
//             }
//         }
//         return -1;
//     }
// }


// // DFS: TLE, 2 cases
// class Solution {
//     int ans;
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         ans = Integer.MAX_VALUE;
//         Map<Integer, List<int[]>> map = new HashMap<>();
//         for (int[] flight : flights) {
//             map.putIfAbsent(flight[0], new ArrayList<>());
//             map.get(flight[0]).add(new int[]{flight[1], flight[2]});
//         }
//         dfs(map, src, dst, k + 1, 0);
//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }
    
//     public void dfs(Map<Integer, List<int[]>> map, int src, int dst, int k, int cost) {
//         if (k < 0) {
//             return;
//         }
//         if (src == dst) {
//             ans = cost;
//             return;
//         }
//         if (!map.containsKey(src)) {
//             return;
//         }
//         for (int[] path : map.get(src)) {
//             if (cost + path[1] > ans) {
//                 continue;
//             }
//             dfs(map, path[0], dst, k - 1, cost + path[1]);
//         }
//     }
// }

// // Djikstra, TLE for 3 cases
// class Solution {
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         Map<Integer, List<int[]>> map = new HashMap<>();
//         for (int[] flight : flights) {
//             map.putIfAbsent(flight[0], new ArrayList<>());
//             map.get(flight[0]).add(new int[] {flight[1], flight[2]});
//         }
        
//         PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//             @Override
//             public int compare(int[] o1, int[] o2) {
//                 // array[0]: cost
//                 return Integer.compare(o1[0], o2[0]);
//             }
//         });
//         pq.offer(new int[] {0, src, k + 1}); // k + 1, means that the destination can be seen as a stop as well
        
//         while (!pq.isEmpty()) {
//             int[] path = pq.poll();
//             int cost = path[0];
//             int city = path[1];
//             int stop = path[2];
//             // check this first
//             if (city == dst) { // arrived at the destination
//                 return cost;
//             }
//             if (stop > 0) { // not arrived yet, so keep searching
//                 // check null first
//                 if (!map.containsKey(city)) { // the city might not have flight going out, but has flight coming in
//                     continue;
//                 }
//                 for (int[] next : map.get(city)) { // get all paths that flying out from the city
//                     pq.add(new int[] {cost + next[1], next[0], stop - 1});
//                 }
//             }
//         }
//         return -1;
//     }
// }