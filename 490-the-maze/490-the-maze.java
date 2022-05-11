class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int startX = start[0];
        int startY = start[1];
        int endX = destination[0];
        int endY = destination[1];
        queue.add(start);
        boolean[][] visited = new boolean[m][n];
        visited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == endX && curr[1] == endY) return true;
            for (int[] dir : directions) {
                int dx = dir[0];
                int dy = dir[1];
                int row = curr[0] + dx;
                int col = curr[1] + dy;
                while (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] == 0) {
                    row += dx;
                    col += dy;
                }
                if (!visited[row - dx][col - dy]) {
                    queue.add(new int[]{row - dx, col - dy});
                    visited[row - dx][col - dy] = true;
                }
            }
        }
        return false;
    }
}

