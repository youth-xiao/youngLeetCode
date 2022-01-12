// class Solution {
    
//     public int orangesRotting(int[][] grid) {
//         if (grid == null || grid.length == 0) return -1;
//         int fresh = 0;
//         int minutes = 0;
//         Queue<int[]> queue = new LinkedList<>();
//         for (int i = 0 ; i < grid.length; i++) {
//             for (int j = 0; j < grid[0].length; j++) {
//                 if (grid[i][j] == 1) {
//                     fresh++;
//                 }
//                 if (grid[i][j] == 2) {
//                     queue.offer(new int[] {i, j});
//                 }
//             }
//         }
        
//         if (fresh == 0) return -1;
        
//         int[][] dir = {{0,-1}, {0,1}, {-1,0}, {1,0}};
        
//         while (!queue.isEmpty()) {
//             minutes++;
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 int[] curr = queue.poll();
//                 for (int d[] : dir) {
//                     int row = curr[0] + d[0];
//                     int col = curr[1] + d[1];
//                     if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || grid[row][col] == 2) {
//                         continue;
//                     }
//                     grid[row][col] = 2;
//                     queue.add(new int[]{row, col});
//                     fresh--;
//                 }
//             }
//         }
        
//         return fresh == 0 ? minutes - 1 : -1;
//     }
// }




class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        //if count of fresh oranges is zero --> return 0 
        if(count_fresh == 0) return 0;
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int dir[] : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    //if x or y is out of bound
                    //or the orange at (x , y) is already rotten
                    //or the cell at (x , y) is empty
                        //we do nothing
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    //mark the orange at (x , y) as rotten
                    grid[x][y] = 2;
                    //put the new rotten orange at (x , y) in queue
                    queue.offer(new int[]{x , y});
                    //decrease the count of fresh oranges by 1
                    count_fresh--;
                }
            }
        }
        return count_fresh == 0 ? count-1 : -1;
    }
}

// class Solution {
//     class Point {
//         int x;
//         int y;
//         int status;
        
//         Point(int x, int y, int status){
//             this.x = x;
//             this.y = y;
//             this.status = status;
//         }
//     }
    
//     public int orangesRotting(int[][] grid) {
//         int total = 0;
//         int startRot = 0;
//         int res = 0;
        
//         for (int i = 0 ; i < grid.length; i++) {
//             for (int j = 0; j < grid[0].length; j++) {
//                 if (grid[i][j] != 0) {
//                     total++;
//                     if (grid[i][j] == 2) {
//                         startRot++;
//                     }
//                 }
//             }
//         }
        
//         if (startRot == 0) return -1;
        
//         Queue<Point> queue = new LinkedList<>();
//         queue.offer(new Point(0, 0, grid[0][0]));
//         boolean[][] visited = new boolean[grid.length][grid[0].length];
//         int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
//         while (!queue.isEmpty()) {
//             Point curr = queue.poll();
//             visited[curr.x][curr.y] = true;
//             if (curr.status == 2) {
//                 boolean valid = false;
//                 // res++;
//                 for (int[] d : dirs) {
//                     int row = curr.x + d[0];
//                     int col = curr.y + d[1];
//                     if ((row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length)
//                         && visited[row][col] == false && grid[row][col] == 1) {
//                         grid[row][col] = 2;
//                         queue.add(new Point(row, col, 2));
//                         valid = true;
//                     }
//                 }
//                 if (valid) res++;      
//             }
//         }
//         return res - 1;
//     }
// }