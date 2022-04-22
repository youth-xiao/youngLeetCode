class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }
        int m = mat.length;
        int n = mat[0].length;
        
        int[] res = new int[m * n];
        int k = 0;
        List<Integer> intermediate = new ArrayList<>();
        for (int d = 0; d < m + n - 1; d++) {
            intermediate.clear();
            int row, col;
            if (d < n) {
                row = 0;
                col = d;
            } else {
                row = d - n + 1;
                col = n - 1;
            }
            while (row < m && col > -1) {
                intermediate.add(mat[row][col]);
                row++;
                col--;
            }
            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }
            for (int i = 0; i < intermediate.size(); i++) {
                res[k++] = intermediate.get(i);
            }
        }
        return res;
    }
}

// class Solution {
//     public int[] findDiagonalOrder(int[][] mat) {
//         int m = mat.length;
//         int n = mat[0].length;
//         int[] res = new int[m * n];
        
//         int row = 0;
//         int col = 0;
        
//         /*
//         [0,0], [0,1] [1,0], [2,0][1,1][0,2], [1,2][2,1], [2,2]
//         */
        
//         int count = 0;
//         // if upwards: row--, col++
//         // if downwards: row++, col--
//         boolean upwards = true;
//         while (count < m * n) {
//             if (upwards) {
//                 while (row >= 0 && col < n) {
//                     res[count] = mat[row][col];
//                     count++;
//                     row--;
//                     col++;
//                 }
//             } else if (!upwards) {
//                 while (row < m && col >= 0) {
//                     res[count] = mat[row][col];
//                     count++;
//                     row++;
//                     col--;
//                 }
//             }
//             upwards = !upwards;
//         }
//         return res;
//     }
// }

// /*

// o o o o
// o o o o
// o o o o

// */