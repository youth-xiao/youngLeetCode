class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }
        
        int count = 0;
        for (String word : words) {
            Set<Character> set = new HashSet<>();
            for (char ch : word.toCharArray()) {
                set.add(ch);
            }
            boolean consistent = true;
            for (char c : set) {
                if (allowedSet.contains(c)) {
                    continue;
                } else {
                    consistent = false;
                    break;
                }
            }
            if (consistent == true) {
                count++;
            }
        }
        return count;
    }
}


// class Solution {
//     public int countConsistentStrings(String allowed, String[] words) {
//         Set<Character> allowedSet = new HashSet<>();
//         for (char c : allowed.toCharArray()) {
//             allowedSet.add(c);
//         }
        
//         int count = 0;
//         for (String word : words) {
//             Map<Character, Integer> map = new HashMap<>();
//             for (char ch : word.toCharArray()) {
//                 map.put(ch, map.getOrDefault(ch, 0) + 1);
//             }
//             Set<Character> mapSet = map.keySet();
//             boolean consistent = true;
//             for (char c : mapSet) {
//                 if (allowedSet.contains(c)) {
//                     continue;
//                 } else {
//                     consistent = false;
//                     break;
//                 }
//             }
//             if (consistent == true) {
//                 count++;
//             }
//         }
//         return count;
//     }
// }