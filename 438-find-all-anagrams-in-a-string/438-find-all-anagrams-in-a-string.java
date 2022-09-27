class Solution {
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int count = map.size(); // how many different characters
        int left = 0, right = 0;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    count--;
                }
            }
            right++;
            
            while (count == 0) {
                char ch = s.charAt(left);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                    if (map.get(ch) > 0) {
                        count++;
                    }
                }
                if (right - left == p.length()) {
                    result.add(left);
                }
                left++;
            }
        }
        return result;
    }
    
    
//     public List<Integer> findAnagrams(String s, String p) {
//         int[] map = new int[26];
//         List<Integer> res = new ArrayList<>();
//         for (char c : p.toCharArray()) {
//             map[c - 'a']++;
//         }
//         int start = 0;
//         int end = 0;
        
//         while (end < s.length()) {
//             if (map[s.charAt(end) - 'a'] > 0) {
//                 map[s.charAt(end) - 'a']--;
//                 end++;
//                 if (end - start == p.length()) {
//                     res.add(start);
//                 }
//             } else if (end == start) {
//                 end++;
//                 start++;
//             }  else {
//                 map[s.charAt(start) - 'a']++;
//                 start++;
//             }
//         }
//         return res;
//     }
}




// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         ArrayList<Integer> res = new ArrayList<>();
//         if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) return res;
        
//         int[] chars = new int[26];
//         for (char c : p.toCharArray()) {
//             chars[c - 'a']++;
//         }
        
//         int start = 0;
//         int end = 0;
//         int len = p.length();
//         int diff = len;
//         char temp;
        
//         for (end = 0; end < len; end++) {
//             temp = s.charAt(end);
//             chars[temp - 'a']--;
//             if (chars[temp - 'a'] >= 0) {
//                 diff--;
//             }
//         }
        
//         if (diff == 0) res.add(0);
        
//         while (end < s.length()) {
//             temp = s.charAt(start);
//             if (chars[temp - 'a'] >= 0) {
//                 diff++;
//             }
//             chars[temp - 'a']++;
//             start++;
//             temp = s.charAt(end);
//             chars[temp = 'a']--;
//             if (chars[temp - 'a'] >= 0) {
//                 diff--;
//             }
//             if (diff == 0) {
//                 res.add(start);
//             }
//             end++;
//         }
//         return res;
//     }
// }