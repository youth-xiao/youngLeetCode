class Solution {
    public int[][] candyCrush(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean keepSearch = false;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j + 2 < col; j++) {
                int element = Math.abs(board[i][j]);
                if (element != 0 && element == Math.abs(board[i][j + 1]) && element == Math.abs(board[i][j + 2])) {
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -element;
                    keepSearch = true;
                }
            }
        }
        
        for (int i = 0; i + 2 < row; i++) {
            for (int j = 0; j < col; j++) {
                int element = Math.abs(board[i][j]);
                if (element != 0 && element == Math.abs(board[i + 1][j]) && element == Math.abs(board[i + 2][j])) {
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = -element;
                    keepSearch = true;
                }
            }
        }
        
        for (int i = 0; i < col; i++) {
            int index = row - 1; // bottom row's index
            for (int j = row - 1; j >= 0; j--) {
                if (board[j][i] > 0) {
                    board[index][i] = board[j][i];
                    index--;
                }
            }
            while (index >= 0) {
                board[index][i] = 0;
                index--;
            }
        }
        
        return keepSearch ? candyCrush(board) : board;
    }
}