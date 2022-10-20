class Solution {
//     public int findLength(int[] nums1, int[] nums2) {
//         if (nums1 == null || nums2 == null) return 0;
//         int m = nums1.length;
//         int n = nums2.length;
        
//         int[][] dp = new int[m + 1][n + 1]; // dp[0][0] is 0, not used, so need to add one more length
//         int maxLength = 0;
        
//         for (int i = 1; i <= m; i++) { // start with 1, not 0
//             for (int j = 1; j <= n; j++) {
//                 if (nums1[i - 1] == nums2[j - 1]) { // dp[][]中的i 对应的是nums里的i-1
//                     dp[i][j] = 1 + dp[i - 1][j - 1]; // dp[i-1][j-1]是当前array的前缀
//                     maxLength = Math.max(maxLength, dp[i][j]);
//                 }
//             }
//         }
//         return maxLength;
//     }
    
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        if (len1 == 0 || len2 == 0 || nums1 == null || nums2 == null) return -1;
        
        int[][] dp = new int[len1 + 1][len2 + 1];
        int maxLength = 0;
        
        for (int i = 1; i < dp.length; i++) {
           for (int j = 1; j < dp[0].length; j++) {
               if (nums1[i - 1] == nums2[j - 1]) {
                   dp[i][j] = dp[i - 1][j - 1] + 1;
                   maxLength = Math.max(maxLength, dp[i][j]);
               }
           }
        }
        
        return maxLength;
    }
}