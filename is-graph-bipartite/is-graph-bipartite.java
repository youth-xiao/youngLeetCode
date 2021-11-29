
// BFS
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] != 0) { // already visited, so skip
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = 1; // 1: red
            while (!queue.isEmpty()) {
                int currNode = queue.poll();
                int currLabel = visited[currNode];
                int neighborLabel = currLabel == 1 ? 2 : 1;
                for (int neighbor : graph[currNode]) {
                    if (visited[neighbor] == 0) {
                        visited[neighbor] = neighborLabel;
                        queue.add(neighbor);
                    } else if (visited[neighbor] != neighborLabel) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}