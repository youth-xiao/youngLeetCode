class Solution {
    public int lengthOfLongestSubstringKDistinct (String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            while (map.size() > k) {
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1);
                if (map.get(l) == 0) {
                    map.remove(l);
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        
        return res;
    }
}


// class Solution {
//     public int lengthOfLongestSubstringKDistinct(String s, int k) {
//         if (k == 0) {return 0;}
//         Set<Character> charSet = new HashSet<>();
//         int longest = 1;
//         int n = s.length();
        
//         int left = 0;
//         int right = 0;
//         while (right < n) {
//             char curr = s.charAt(right);
//             if (charSet.size() > k) {
//                 left++;
//                 charSet = new HashSet<>();
//             } else if (!charSet.contains(curr) && charSet.size() < k) {
//                 charSet.add(curr);
//             } else if (charSet.contains(curr) && charSet.size() <= k) {
//             }
//             right++;
//             longest = Math.max(longest, right - left);
//         }
//         return longest;
        
        
        // for (int i = 0; i < n - 1; i++) {
        //     charSet = new HashSet<>();
        //     int end = i;
        //     while (charSet.size() <= k && end < n) {
        //         char curr = s.charAt(end);
        //         if (!charSet.contains(curr) && charSet.size() < k) {
        //             charSet.add(curr);
        //             end++;
        //         } else if (charSet.contains(curr) && charSet.size() == k) {
        //             end++;
        //         }
        //         longest = Math.max(longest, end - i);
        //     }
        // }
        // return longest;
//     }
// }


// class Solution {
//     public int lengthOfLongestSubstringKDistinct(String s, int k) {
//         int longest = 1;
//         int n = s.length();
//         if (n * k == 0) {return 0;}
        
//         int left = 0;
//         int right = 0;
        
//         Map<Character, Integer> rightMostPos = new HashMap<>();
        
//         while (right < n) {
//             rightMostPos.put(s.charAt(right), right++);
//             if (rightMostPos.size() == k + 1) {
//                 int lowestIndex = Collections.min(rightMostPos.values());
//                 rightMostPos.remove(s.charAt(lowestIndex));
//                 left = lowestIndex + 1;
//             }
//             longest = Math.max(longest, right - left);
//         }
//         return longest;
//     }
// }