class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int newK = k % n;
        int[] results = new int[n];
        int j = 0;
        for (int i = n - newK; i < n; i++) {
            results[j++] = nums[i];
        }
        
        for (int i = 0; i < n - newK; i++) {
            results[j++] = nums[i];
        }
        
        for (int i = 0; i < n; i++) {
            nums[i] = results[i];
        }
    }
}