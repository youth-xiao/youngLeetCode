class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int size = matrix.length * matrix[0].length;
        
        while (res.size() < size) {
            for (int i = left; i <= right & res.size() < size; i++) { // row不变 col变（向右） 所以i在col
                res.add(matrix[top][i]); // 注意 [i] 所在row/column 会有变化
            }
            top++;
            
            for (int i = top; i <= bottom && res.size() < size; i++) { // row变 （向下） col不变 所以i在row
                res.add(matrix[i][right]);
            }
            right--;
            
            for (int i = right; i >= left && res.size() < size; i--) { // row不变 col变 （向左） 所以i在col
                res.add(matrix[bottom][i]);
            }
            bottom--;
            
            for (int i = bottom; i >= top && res.size() < size; i--) { // row变 （向上） col不变 所以i在row
                res.add(matrix[i][left]);
            }
            left++;
        }
        
        return res;
    }
}