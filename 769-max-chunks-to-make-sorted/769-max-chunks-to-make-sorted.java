class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int n = arr.length;
        int pivotMax[] = new int[n];
        
        pivotMax[0] = arr[0];
        
        for (int i = 1; i < n; i++) {
            pivotMax[i] = Math.max(arr[i], pivotMax[i - 1]);
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (pivotMax[i] == i) {
                count++;
            }
        }
        
        return count;
    }
}