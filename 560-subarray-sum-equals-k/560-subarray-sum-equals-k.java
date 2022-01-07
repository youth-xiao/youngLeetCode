// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int count = 0;
//         int sum = 0;
//         // Map<sum, count>
//         Map<Integer, Integer> map = new HashMap<>();
//         map.put(0, 1); // initially, sum = 0, and there is just one zero
        
//         for (int i = 0; i < nums.length; i++) {
//             sum += nums[i];
//             if (map.containsKey(sum - k)) {
//                 count += map.get(sum - k);
//             }
//             map.put(sum, map.getOrDefault(sum, 0) + 1);
//         }
//         return count;
//     }
// }


class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0; // don't forget this line
        
        for (int i = 1; i <= nums.length; i++) { // start with i = 1, not i = 0
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
        }
        
        for (int left = 0; left < nums.length; left++) {
            for (int right = left + 1; right <= nums.length; right++) {
                if (prefixSum[right] - prefixSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}