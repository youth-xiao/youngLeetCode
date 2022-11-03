class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int length = dfs(grid, i, j);
                    perimeter += length;
                }
            }
        }
        return perimeter;
    }
    
    private int dfs(int[][] grid, int i, int j) {
        if (!withinBound(grid, i, j)) {
            return 1;
        }
        
        if (grid[i][j] == 0) {
            return 1;
        }
        
        if (grid[i][j] != 1) {
            return 0;
        }
        
        grid[i][j] = 2;
        
        return dfs(grid, i + 1, j) 
                + dfs(grid, i - 1, j)
                + dfs(grid, i, j + 1)
                + dfs(grid, i, j - 1);
    }
    
    private boolean withinBound(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}