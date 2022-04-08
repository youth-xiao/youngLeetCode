class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int pivotMax[] = new int[n];
        
        pivotMax[0] = arr[0];
        
        for (int i = 1; i < n; i++) {
            pivotMax[i] = Math.max(arr[i], pivotMax[i - 1]);
        }
        
        int pivotMin[] = new int[n];
        pivotMin[n - 1] = arr[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            pivotMin[i] = Math.min(arr[i], pivotMin[i + 1]);
        }
        
        int count = 0;
        
        for (int i = 0; i < n - 1; i++) {
            if (pivotMax[i] <= pivotMin[i + 1]) {
                count++;
            }
        }
        
        return count + 1;
    }
}