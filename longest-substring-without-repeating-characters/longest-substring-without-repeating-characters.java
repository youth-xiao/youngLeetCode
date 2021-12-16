// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if (s.length() == 0) return 0;
//         int[] map = new int[256];
//         int start = 0;
//         int maxLength = 1;
//         for (int i = 0; i < s.length(); i++) {
//             map[s.charAt(i)]++; // the character can be converted to a certain integer in the form of array
//             while (map[s.charAt(i)] > 1) {
//                 map[s.charAt(start)]--; // loop until the frame (between start and i) does not contain the previously duplicated character
//                 start++;
//             }
//             maxLength = Math.max(maxLength, i - start + 1); // the key is to know the current length is (i - start  + 1) (two pointers)
//         }
//         return maxLength;
//     }
// }


class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int[] chars = new int[128];
        int maxLength = 1;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;
            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}