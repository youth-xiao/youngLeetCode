class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, distance);
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
    
    private void dfs(int[][] maze, int[] start, int[][] distance) {
        int[][] directionMap = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] direction : directionMap) {
            int x = start[0] + direction[0];
            int y = start[1] + direction[1];
            int steps = 0;
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                x += direction[0];
                y += direction[1];
                steps++;
            }
            if (distance[start[0]][start[1]] + steps < distance[x - direction[0]][y - direction[1]]) {
               distance[x - direction[0]][y - direction[1]] =  distance[start[0]][start[1]] + steps;
                dfs(maze, new int[]{x - direction[0], y - direction[1]}, distance);
            }
        }
    }
}


// class Solution {
//     public int shortestDistance(int[][] maze, int[] start, int[] destination) {
//         int x_start = start[0];
//         int y_start = start[1];
//         return travel(maze, destination, x_start, y_start, 0);
//     }
    
//     private int travel(int[][] maze, int[] destination, int row, int col, int steps) {
//         // boundaries
//         int height = maze.length;
//         int width = maze[0].length;
//         if (row >= height || col >= width || row < 0 || col < 0) {
//             return 0;
//         } else if (row == destination[0] && col == destination[1]) {
//             return steps;
//         } else if (maze[row + 1][col] == 1) {
//             travel(maze, destination, row - 1, col, steps + 1);
//             travel(maze, destination, row, col + 1, steps + 1);
//             travel(maze, destination, row, col - 1, steps + 1);
//         } else if (maze[row - 1][col] == 1) {
//             travel(maze, destination, row + 1, col, steps + 1);
//             travel(maze, destination, row, col + 1, steps + 1);
//             travel(maze, destination, row, col - 1, steps + 1);
//         } else if (maze[row][col + 1] == 1) {
//             travel(maze, destination, row, col - 1, steps + 1);
//             travel(maze, destination, row + 1, col, steps + 1);
//             travel(maze, destination, row - 1, col, steps + 1);
//         } else if (maze[row][col - 1] == 1) {
//             travel(maze, destination, row, col + 1, steps + 1);
//             travel(maze, destination, row + 1, col, steps + 1);
//             travel(maze, destination, row - 1, col, steps + 1);
//         }
//         return steps;
//     }
// }