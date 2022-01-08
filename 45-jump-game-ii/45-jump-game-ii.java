// class Solution {
//     public int jump(int[] nums) {
//         int start = 0, end = 1;
//         int ans = 0;
        
//         while (end < nums.length) {
//             int maxPos = 0;
//             for (int i = start; i < end; i++) {
//                 maxPos = Math.max(maxPos, i + nums[i]);
//             }
//             start = end;
//             end = maxPos + 1;
//             ans++;
//         }
        
//         return ans;
//     }
// }

class Solution {
    public int jump(int[] nums) {
        int ans = 0, end = 0, maxPos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                ans++;
            }
        }
        return ans;
    }
}