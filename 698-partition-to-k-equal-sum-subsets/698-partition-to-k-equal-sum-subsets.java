class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) return true;
        int N = nums.length;
        if (N < k) return false;
        int total = 0;
        for (int i : nums) total += i;
        if (total % k != 0) return false;
        
        int subset = total / k;
        int[] subsetSum = new int[k];
        boolean[] taken = new boolean[N];
        
        Arrays.fill(subsetSum, 0);
        Arrays.fill(taken, false);
        
        subsetSum[0] = nums[N - 1];
        taken[N - 1] = true;
        
        return possiblePartitionRecursion(nums, subsetSum, taken, subset, k, N, 0, N - 1);
    }
    
    private boolean possiblePartitionRecursion(int nums[], int subsetSum[], boolean taken[],
                                              int subset, int k, int N, int currIndex, int limitIndex) {
        if (subsetSum[currIndex] == subset) {
            if (currIndex == k - 2) {
                return true;
            }
            return  possiblePartitionRecursion(nums, subsetSum, taken, subset, k, N, currIndex + 1, N - 1);
        }
        for (int i = limitIndex; i >= 0; i--) {
            if (taken[i]) continue;
            int temp = subsetSum[currIndex] + nums[i];
            if (temp <= subset) {
                taken[i] = true;
                subsetSum[currIndex] += nums[i];
                boolean next = possiblePartitionRecursion(nums, subsetSum, taken, subset, k, N, currIndex, i - 1);
                taken[i] = false;
                subsetSum[currIndex] -= nums[i];
                if (next) return true;
            }
        }
        return false;
    }
}