class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        
        for (int i = 0; i < N; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char ch = board[r][c];
                if (ch == '.') {
                    continue;
                }
                
                if (rows[r].contains(ch)) {
                    return false;
                }
                rows[r].add(ch);
                
                if (cols[c].contains(ch)) {
                    return false;
                }
                cols[c].add(ch);
                
                int boxIdx = (r / 3) * 3 + c / 3;
                if (boxes[boxIdx].contains(ch)) {
                    return false;
                }
                boxes[boxIdx].add(ch);
            }
        }
        return true;
    }
}


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