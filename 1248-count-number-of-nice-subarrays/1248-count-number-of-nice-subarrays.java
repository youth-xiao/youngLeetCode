class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0, right = 0;
        int oddCount = 0, res = 0;
        while (right < nums.length) {
            if ((nums[right++] & 1) == 1) {
                oddCount++;
            }
            
            if (oddCount == k) {
                int temp = right;
                while (right < nums.length && (nums[right] & 1) == 0) {
                    right++;
                }
                int rightEvenCount = right - temp;
                int leftEvenCount = 0;
                while ((nums[left] & 1) == 0) {
                    leftEvenCount++;
                    left++;
                }
                res += (leftEvenCount + 1) * (rightEvenCount + 1);
                left++;
                oddCount--;
            }
        }
        return res;
    }
}