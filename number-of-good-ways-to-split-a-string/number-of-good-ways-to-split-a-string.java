class Solution {
    public int numSplits(String s) {
        int n = s.length();
        int splits = 0;
        int[] left = new int[26];
        int[] right = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            right[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            left[c - 'a']++;
            right[c - 'a']--;
            int leftDistinct = getDistinct(left);
            int rightDistinct = getDistinct(right);
            if (leftDistinct == rightDistinct) {
                splits++;
            }
        }
        return splits;
    }
    
    private int getDistinct(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if (i != 0) {
                count++;
            }
        }
        return count;
    }
}


// // TLE
// class Solution {
//     public int numSplits(String s) {
//         int n = s.length();
//         int goodCount = 0;
//         for (int i = 1; i < n; i++) {
//             String l = s.substring(0, i);
//             String r = s.substring(i, n);
//             Set<Character> set1 = new HashSet<>();
//             Set<Character> set2 = new HashSet<>();
//             for (char c1 : l.toCharArray()) {
//                 set1.add(c1);
//             }
//             for (char c2 : r.toCharArray()) {
//                 set2.add(c2);
//             }
//             if (set1.size() == set2.size()) {
//                 goodCount++;
//             }
//         }
//         return goodCount;
//     }
// }