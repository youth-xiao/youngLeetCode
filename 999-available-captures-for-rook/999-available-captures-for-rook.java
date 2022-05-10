class Solution {
    public int numRookCaptures(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int startX = -1;
        int startY = -1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }
        
        int[][] directions = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        
        int count = 0;
        
        for (int[] dir : directions) {
            int row = startX;
            int col = startY;
            while (row >= 0 && row < m && col >= 0 && col < n) {
                row += dir[0];
                col += dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n) {
                    if (board[row][col] == '.') {
                        continue;
                    } else if (board[row][col] == 'B') {
                        break;
                    } else if (board[row][col] == 'p') {
                        count++;
                        break;
                    }
                }
            }
        }
        
        return count;
    }
}