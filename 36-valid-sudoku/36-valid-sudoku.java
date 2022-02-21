// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         Map<Integer, Set<Integer>> row = new HashMap<>(),
//                                    col = new HashMap<>(),
//                                    box = new HashMap<>();
//         for (int i = 0; i < 9; i++) {
//             row.put(i, new HashSet<>());
//             col.put(i, new HashSet<>());
//             box.put(i, new HashSet<>());
//         }
        
//         for (int i = 0; i < 9; i++) {
//             for (int j = 0; j < 9; j++) {
//                 char c = board[i][j];
//                 if (c == '.') {
//                     continue;
//                 }
//                 int num = c - '0';
//                 int boxIndex = i / 3 * 3 + j / 3;
//                 if (row.get(i).contains(num) || col.get(i).contains(num) ||
//                     box.get(boxIndex).contains(num)) {
//                     return false;
//                 }
//                 row.get(i).add(num);
//                 col.get(i).add(num);
//                 box.get(boxIndex).add(num);
//             }
//         }
//         return true;
//     }
// }

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // Use hash set to record the status
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = board[r][c];

                // Check if the position is filled with number
                if (val == '.') {
                    continue;
                }

                // Check the row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // Check the column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}