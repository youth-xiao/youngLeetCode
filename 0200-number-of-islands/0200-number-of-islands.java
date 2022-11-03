class Solution {
    public int numIslands(char[][] grid) {
        int number = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    number++;
                }
            }
        }
        return number;
    }
    
    private boolean withinBound(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
    
    // for this question, we just need to count then number of islands, not the actual area, therefore we don't need to return anything
    private void dfs(char[][] grid, int i, int j) {
        // remember to include grid[i][j] != '1'
        if (!withinBound(grid, i, j) || grid[i][j] != '1') return;
        grid[i][j] = '2';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}