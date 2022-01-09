class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        
        int[] neighbor = {0, 1, -1};
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int liveCells = 0;
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (!(neighbor[m] == 0 && neighbor[n] == 0)) {
                            int r = i + neighbor[m];
                            int c = j + neighbor[n];
                            if ((r < row && r >= 0) && (c < col && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                liveCells++;
                            }
                        }
                    }
                }
                
                if ((board[i][j] == 1) && (liveCells < 2 || liveCells > 3)) {
                    board[i][j] = -1;
                }
                
                if (board[i][j] == 0 && liveCells == 3) {
                    board[i][j] = 2;
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
        
    }
}


// class Solution {
//     public void gameOfLife(int[][] board) {
//         int row = board.length;
//         int col = board[0].length;
//         int[][] copyBoard = new int[row][col];
        
//         for (int i = 0; i < row; i++) {
//             for (int j = 0; j < col; j++) {
//                 copyBoard[i][j] = board[i][j];
//             }
//         }
        
//         int[] neighbor = {0, 1, -1};
        
//         for (int i = 0; i < row; i++) {
//             for (int j = 0; j < col; j++) {
//                 int liveCells = 0;
//                 for (int m = 0; m < 3; m++) {
//                     for (int n = 0; n < 3; n++) {
//                         if (!(neighbor[m] == 0 && neighbor[n] == 0)) {
//                             int r = i + neighbor[m];
//                             int c = j + neighbor[n];
//                             if ((r < row && r >= 0) && (c < col && c >= 0) && copyBoard[r][c] == 1) {
//                                 liveCells++;
//                             }
//                         }
//                     }
//                 }
                
//                 if ((copyBoard[i][j] == 1) && (liveCells < 2 || liveCells > 3)) {
//                     board[i][j] = 0;
//                 }
                
//                 if (copyBoard[i][j] == 0 && liveCells == 3) {
//                     board[i][j] = 1;
//                 }
//             }
//         }
//     }
// }