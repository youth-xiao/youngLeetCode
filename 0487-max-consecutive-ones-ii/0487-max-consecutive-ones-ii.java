class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int zeroCount = 0;
        int left = 0;
        int right = 0;
        int longest = 0;
        
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount == 2) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            longest = Math.max(longest, right - left + 1);
            right++;
        }
        
        return longest;
    }
}