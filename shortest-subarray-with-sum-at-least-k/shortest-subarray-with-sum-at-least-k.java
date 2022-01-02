class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int len = nums.length;
        int minLength = len + 1;
        long[] prefixSum = new long[len + 1];
        
        for (int i = 0; i < len; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        Deque<Integer> deq = new ArrayDeque<>(); // store index
        
        for (int i = 0; i < len + 1; i++) {
            while (deq.size() > 0 && prefixSum[i] - prefixSum[deq.getFirst()] >= k) {
                minLength = Math.min(minLength, i - deq.pollFirst());
            }
            
            while (deq.size() > 0 && prefixSum[i] <= prefixSum[deq.getLast()]) {
                deq.pollLast();
            }
            
            deq.addLast(i);
        }
        
        return minLength <= len ? minLength : -1;
        
    }
}