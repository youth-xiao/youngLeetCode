class Solution {
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    class DistAndPath implements Comparable<DistAndPath> {
        int dist;
        String path;
        
        public DistAndPath(int dist, String path) {
            this.dist = dist;
            this.path = path;
        }
        
        public int compareTo(DistAndPath other) {
            if (this.dist != other.dist) {
                return this.dist - other.dist;
            }
            return path.compareTo(other.path);
        }
    }
    
    public int[] dx = {0, 1, 0, -1};
    public int[] dy = {1, 0, -1, 0};
    public String[] dirStr = {"r", "d", "l", "u"};
    
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return "impossible";
        }
        int m = maze.length;
        int n = maze[0].length;
        
        DistAndPath[][] cost = new DistAndPath[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = new DistAndPath(Integer.MAX_VALUE, "");
            }
        }
        
        cost[ball[0]][ball[1]].dist = 0;
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(ball[0], ball[1]));
        
        while(!queue.isEmpty()) {
            Point curr = queue.poll();
            for (int d = 0; d < 4; d++) {
                Point next = new Point(curr.x, curr.y);
                DistAndPath dp = new DistAndPath(cost[curr.x][curr.y].dist, 
                                                 cost[curr.x][curr.y].path + dirStr[d]);
                while (!isWall(maze, next.x + dx[d], next.y + dy[d])) {
                    next.x += dx[d];
                    next.y += dy[d];
                    dp.dist += 1;
                    
                    if (next.x == hole[0] && next.y == hole[1]) {
                        break;
                    }
                }
                
                if (cost[next.x][next.y].compareTo(dp) > 0) {
                    cost[next.x][next.y] = dp;
                    if (next.x != hole[0] || next.y != hole[1]) {
                        queue.offer(next);
                    }
                }
            }
        }
        
        if (cost[hole[0]][hole[1]].dist == Integer.MAX_VALUE) {
            return "impossible";
        }
        
        return cost[hole[0]][hole[1]].path;
    }
    
    private boolean isWall(int[][] maze, int x, int y) {
        int m = maze.length;
        int n = maze[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return true;
        }
        return maze[x][y] == 1;
    }
}