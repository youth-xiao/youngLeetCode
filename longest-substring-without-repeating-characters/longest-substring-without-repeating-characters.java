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



// // SLIDING WINDOW
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if (s.length() == 0) return 0;
//         int[] chars = new int[128]; // the array only stores the frequency of characters within the sliding window, not within the whole array
//         int maxLength = 1;
//         int left = 0;
//         int right = 0;
//         while (right < s.length()) {
//             char r = s.charAt(right);
//             chars[r]++;
//             while (chars[r] > 1) { // this means the current sliding window contains duplicates
//                 char l = s.charAt(left);
//                 chars[l]--; // we reduce the frequency of that duplicated character before we increment the lower bound of the sliding window
//                 left++; // shifting the lower bound to the right to eliminate duplicates
//             }
//             maxLength = Math.max(maxLength, right - left + 1);
//             right++; // no matter what, we increment right for every loop b/c we want to check all the characters
//         }
//         return maxLength;
//     }
// }

// // Hashmap
// class Solution {
//      public int lengthOfLongestSubstring(String s) {
//          Map<Character, Integer> map = new HashMap<>();
//          int start = 0;
//          int maxLength = 0;
//          for (int i = 0; i < s.length(); i++) {
//              char c = s.charAt(i);
//              if (map.containsKey(c)) { // duplicates found
//                  if (map.get(c) >= start) { // when the duplicate is within the sliding window
//                     start = map.get(c) + 1; // we shifting the lower bound of the sliding window to the right
//                  }
//              }
//              maxLength = Math.max(maxLength, i - start + 1);
//              map.put(c, i); // PUT it anyways, no matter if the map contains the key or not
//          }
//          return maxLength;
//      }
// }

// One pass
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) { // aka. right pointer
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c)); // get the right-most index
            }
            map.put(c, i + 1);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}