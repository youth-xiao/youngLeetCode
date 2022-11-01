class Solution {
    public int[] findBall(int[][] grid) {
        int columns = grid[0].length;
        int[] answer = new int[columns];
        for (int i = 0; i < columns; i++) {
            answer[i] = dfs(0, i, grid);
        }
        return answer;
    }
    
    private int dfs(int row, int col, int[][] grid) {
        if (row == grid.length) return col;
        int nextColumn = col + grid[row][col];
        if (nextColumn < 0 || 
            nextColumn > grid[0].length - 1 ||
            grid[row][col] != grid[row][nextColumn]) {
            return -1;
        }
        return dfs(row + 1, nextColumn, grid);
    }
}