class Solution {
    public int jump(int[] nums) {
        int start = 0, end = 1;
        int ans = 0;
        
        while (end < nums.length) {
            int maxPos = 0;
            for (int i = start; i < end; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            start = end;
            end = maxPos + 1;
            ans++;
        }
        
        return ans;
    }
}