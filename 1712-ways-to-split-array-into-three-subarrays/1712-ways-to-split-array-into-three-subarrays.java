class Solution {
    public int waysToSplit(int[] nums) {
        final int MOD = 1000000007;
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        
        long count = 0;
        
        for (int i = 0, left = 1, right = 1; i < n - 1; i++) {
            left = Math.max(left, i + 1);
            right = Math.max(right, i + 1);
            
            while (right < n - 1 && prefixSum[n - 1] - prefixSum[right] >= prefixSum[right] - prefixSum[i]) {
                right++;
            }
            
            while (left < n - 1 && prefixSum[left] - prefixSum[i] < prefixSum[i]) {
                left++;
            }
            
            if (left <= right) {
                count += (right - left);
            }
        }
        
        return (int) (count % MOD);
    }
}

// int sum = prefixSum[n - 1];
//         int part = sum / 3;
        
//         int left = 0;
//         int right = n - 1;
//         int count = 0;
        
//         // [1 | 2  2  2  5 | 0]
//         // [1 | 3  5  7  12 | 12]
        
//         int index = 0;
//         // left part, find the furthest left wall
//         while (prefixSum[index] <= part) {
//             index++;
//         }
        
//         int leftBound = index;
        
//         while (left < right && left <= leftBound) {
//             int firstPartSum = prefixSum[left];
//             int secondPartSum = prefixSum[right] - prefixSum[left];
//             int thirdPartSum = prefixSum[n - 1] - prefixSum[right];
//             if (secondPartSum > thirdPartSum) {
//                 right--;
//             } else if (firstPartSum <= secondPartSum && secondPartSum <= thirdPartSum) {
//                 count++;
//                 right--;
//             }
//             left++;
//         }
//         return count;