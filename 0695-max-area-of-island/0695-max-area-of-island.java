class Solution {
    
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int currArea = dfs(grid, i, j);
                    maxArea = Math.max(currArea, maxArea);
                }
            }
        }
        
        return maxArea;
    }
    
    private int dfs(int[][] grid, int row, int col) {
        if (!validBoundary(grid, row, col)) {
            return 0;
        }
        if (grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = 2;
        return 1 + dfs(grid, row + 1, col) + dfs(grid, row - 1, col) + dfs(grid, row, col + 1) + dfs(grid, row, col - 1);
    }
    
    
    private boolean validBoundary(int[][] grid, int row, int col) {
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0) {
            return false;
        }
        return true;
    }
}