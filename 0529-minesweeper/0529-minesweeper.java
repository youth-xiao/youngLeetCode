class Solution {
    // 上 下 左 右 左上 左下 右上 右下
    int[] dx = new int[] {0, 0, -1, 1, -1, -1, 1, 1};
    int[] dy = new int[] {-1, 1, 0, 0, -1, 1, -1, 1};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        
        int r = click[0], c = click[1];
        
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
        } else {
            dfs(board, r, c);
        }
        return board;
    }
    
    private void dfs(char[][] board, int i, int j) {
        int count = 0;
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                continue;
            }
            if (board[x][y] == 'M') {
                count++;
            }
        }
        
        if (count > 0) {
            board[i][j] = (char) (count + '0');
            return;
        }
        
        board[i][j] = 'B';

        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') {
                continue;
            }
            dfs(board, x, y);
        }
    }
}