class Solution {
    private int[] memo;
    
    public int rob(int[] nums) {
        this.memo = new int[nums.length];
        Arrays.fill(this.memo, -1);
        return this.robFrom(0, nums);
    }
    
    private int robFrom(int i, int[] nums) {
        if (i >= nums.length) {
            return 0;
        }
        if (this.memo[i] > -1) {
            return this.memo[i];
        }
        int ans = Math.max(this.robFrom(i + 1, nums), this.robFrom(i + 2, nums) + nums[i]);
        this.memo[i] = ans;
        return ans;
    }
}


// class Solution {
//     public int rob(int[] nums) {
//         int len = nums.length;
//         if (nums == null || len == 0) return 0;
//         int[] dp = new int[len];
//         dp[0] = nums[0];
//         if (len == 1) return dp[0];
//         dp[1] = Math.max(nums[0], nums[1]);
//         if (len == 2) return dp[1];
        
//         for (int i = 2; i < len; i++) {
//             dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
//         }
        
//         return dp[len - 1];
//     }
// }


// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n + 1];
//         dp[1] = nums[0];
//         for (int i = 2; i <= n; i++) {
//             dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
//         }
//         return dp[n];
//     }
// }