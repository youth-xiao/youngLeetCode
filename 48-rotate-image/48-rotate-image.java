// class Solution {
//     public void rotate(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         for (int i = 0; i < m / 2; i++) {
//             for (int j = 0; j < (m + 1) / 2; j++) {
//                 int temp = matrix[i][j];
//                 matrix[i][j] = matrix[n - j - 1][i];
//                 matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
//                 matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
//                 matrix[j][n - i - 1] = temp;
//             }
//         }
//     }
// }

class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - i - 1][j];
                matrix[m - i - 1][j] = temp;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}