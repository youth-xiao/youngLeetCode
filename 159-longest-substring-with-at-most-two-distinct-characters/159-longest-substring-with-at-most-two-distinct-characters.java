// class Solution {
//     public int lengthOfLongestSubstringTwoDistinct(String s) {
//         int len = s.length();
//         if (len < 3) {
//             return len;
//         }
//         int left = 0, right = 0;
//         int max_len = 2;
//         HashMap<Character, Integer> map = new HashMap<>();
//         while (right < len) {
//             map.put(s.charAt(right), right++);
//             // update the map until valid
//             if (map.size() > 2) {
//                 int del_index = Collections.min(map.values());
//                 map.remove(s.charAt(del_index));
//                 left = del_index + 1;
//             }
//             max_len = Math.max(right - left, max_len);
//         }
//         return max_len;
//     }
// }


class Solution {
    public int lengthOfLongestSubstringTwoDistinct (String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > 2) {
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