class Solution {
    Random random;
    int[] prefixSum;

    public Solution(int[] w) {
        random = new Random();
        int n = w.length;
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.prefixSum = w;
    }
    
    public int pickIndex() {
        int n = prefixSum.length;
        int randIndex = random.nextInt(prefixSum[n - 1]) + 1;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid] == randIndex) {
                return mid;
            } else if (prefixSum[mid] < randIndex) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */