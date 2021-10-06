class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int row = box.length; // n
        int col = box[0].length; // m
        char[][] rotated = new char[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rotated[j][row - i - 1] = box[i][j];
            }
        }
        
        for (int i = col - 1; i >= 0; i--) {
            for (int j = 0; j < row; j++) {
                if (rotated[i][j] == '#') {
                    for (int k = i + 1; k < col; k++) {
                        while (k < col && rotated[k][j] == '.') {
                            k++;
                        }
                        rotated[i][j] = '.';
                        rotated[k - 1][j] = '#';
                        break;
                    }
                }
            }
        }
        return rotated;
    }
}