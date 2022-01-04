class Solution {
    public String minWindow (String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int left = 0;
        int minStart = 0;
        int res = Integer.MAX_VALUE;
        int validCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.containsKey(curr)) {
                if (map.get(curr) > 0) {
                    validCount++;
                }
                map.put(curr, map.get(curr) - 1);
            }
            
            while (validCount == t.length()) {
                if (i - left + 1 < res) {
                    res = i - left + 1;
                    minStart = left;
                }
                char l = s.charAt(left);
                if (map.containsKey(l)) {
                    map.put(l, map.getOrDefault(l, 0) + 1);
                    if (map.get(l) > 0) {
                        validCount--;
                    }
                }
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + res);
    }
}

// class Solution {
//     public String minWindow(String s, String t) {
//         String ans = "";
//         int[] mapS = new int[256]; // 重点！只需记录有效字符的数量 t没有的字符即使出现在s里也不需要记录
//         int[] mapT = new int[256];
//         int validCount = 0;
//         int start = 0; // position where the window starts on the left side

//         for (int i = 0; i < t.length(); i++) { // 先把target string的字符放进array里
//             mapT[t.charAt(i)]++;
//         }

//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             if (mapT[c] > 0) { // 如果某字符是target string所含的字符
//                 mapS[c]++; // 计入该字符在s里的频率
//                 if (mapT[c] >= mapS[c]) { // 如果还没搜集超过目标字符的数量 则目前搜集的有效字符可以算进参考范围内
//                     validCount++;
//                 }
//             }
//             if (validCount == t.length()) { // 如果已经搜集到了target string的长度的数量
//                 // 则检查起始字符其数量是否已经超过target string所需的数量 如果超过 就表示可以向右移动窗口 寻找更短的substring
//                 // 如果起始字符是无效字符（target string不含有的字符）那也可以向右移动window
//                 while (mapS[s.charAt(start)] > mapT[s.charAt(start)] || mapT[s.charAt(start)] == 0) {
//                     if (mapS[s.charAt(start)] > mapT[s.charAt(start)]) {
//                         mapS[s.charAt(start)]--; // 如果s的某字符数量超标 则减一
//                     }
//                     start++; // window向右移动
//                 }
//                 if (ans.equals("") || i - start + 1 < ans.length()) { // 如果是第一次找到valid substring 或者 valid substring比先前的答案还要短
//                     ans = s.substring(start, i + 1); // 更新substring，注意 i + 1是exclusive
//                 }
//             }
//         }
//         return ans;
//     }
// }