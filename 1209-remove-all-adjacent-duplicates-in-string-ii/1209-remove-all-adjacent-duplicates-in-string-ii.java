class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> count = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                count.push(1);
            } else {
                int newCount = count.pop() + 1;
                if (newCount == k) {
                    sb.delete(i - k + 1, i + 1); // delete(start, end), start is inclusive, end is exclusive
                    i = i - k; // since we already deleted duplicates, the next new char (originally i + 1) will be shifted to the left by k units (i - k) + 1, in the current loop, i is i - k, but do will increment in the next loop
                } else {
                    count.push(newCount);
                }
            }
        }
        return sb.toString();
    }
}

// class Solution {
//     public String removeDuplicates(String s, int k) {
//         Map<Character, Integer> map = new HashMap<>();
//         Stack<Character> stack = new Stack<>();
//         for (int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);
//             stack.push(ch);
//             map.put(ch, map.getOrDefault(ch, 0) + 1);
//             if (map.get(ch) >= k) {
//                 for (int j = 0; j < k; j++) {
//                     stack.pop();
//                     map.put(ch, map.get(ch) - 1);
//                     if (map.get(ch) == 0) {
//                         map.remove(ch);
//                     }
//                 }
//             } 
//         }
//         StringBuilder sb = new StringBuilder();
//         while (!stack.isEmpty()) {
//             char c = stack.pop();
//             sb.insert(0, c);
//         }
//         return sb.toString();
//     }
// }