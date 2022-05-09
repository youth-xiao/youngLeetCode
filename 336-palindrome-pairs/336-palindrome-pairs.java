class Solution {
    private static class TrieNode {
        TrieNode[] next;
        int index;
        List<Integer> list;
        
        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            search(words, i, root, res);
        }
        return res;
    }
    
    private void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';
            if (root.next[j] == null) {
                root.next[j] = new TrieNode();
            }
            if (isPalindrome(word, 0, i)) {
                root.list.add(index);
            }
            root = root.next[j];
        }
        root.list.add(index);
        root.index = index;
    }
    
    private void search(String[] words, int i, TrieNode root, List<List<Integer>> res) {
        for (int j = 0; j < words[i].length(); j++) {
            if (root.index >= 0 && root.index != i
               && isPalindrome(words[i], j, words[i].length() - 1)) {
                res.add(Arrays.asList(i, root.index));
            }
            root = root.next[words[i].charAt(j) - 'a'];
            if (root == null) return;
        }
        for (int j : root.list) {
            if (i == j) continue;
            res.add(Arrays.asList(i, j));
        }
    }
    
    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }
}



// class Solution {
//     public List<List<Integer>> palindromePairs(String[] words) {
//         Map<String, Integer> wordMap = new HashMap<>();
//         for (int i = 0; i < words.length; i++) {
//             wordMap.put(words[i], i);
//         }
        
//         List<List<Integer>> res = new ArrayList<>();
        
//         for (String word : wordMap.keySet()) {
//             int currWordIndex = wordMap.get(word);
//             String reverseWord = new StringBuilder(word).reverse().toString();
            
//             if (wordMap.containsKey(reverseWord) 
//                 && wordMap.get(reverseWord) != currWordIndex) {
//                 res.add(Arrays.asList(currWordIndex, wordMap.get(reverseWord)));
//             }
            
//             for (String suffix : allValidSuffixes(word)) {
//                 String reverseSuffix = new StringBuilder(suffix).reverse().toString();
//                 if (wordMap.containsKey(reverseSuffix)) {
//                     res.add(Arrays.asList(wordMap.get(reverseSuffix), currWordIndex));
//                 }
//             }
            
//             for (String prefix : allValidPrefixes(word)) {
//                 String reversePrefix = new StringBuilder(prefix).reverse().toString();
//                 if (wordMap.containsKey(reversePrefix)) {
//                     res.add(Arrays.asList(currWordIndex, wordMap.get(reversePrefix)));
//                 }
//             }
//         }
//         return res;
//     }
    
//     private List<String> allValidPrefixes(String word) {
//         List<String> validPrefixes = new ArrayList<>();
//         int n = word.length();
//         for (int i = 0; i < n; i++) {
//             if (isPalindromeBetween(word, i, n - 1)) {
//                 validPrefixes.add(word.substring(0, i));
//             }
//         }
//         return validPrefixes;
//     }
    
//     private List<String> allValidSuffixes(String word) {
//         List<String> validSuffixes = new ArrayList<>();
//         int n = word.length();
//         for (int i = 0; i < n; i++) {
//             if (isPalindromeBetween(word, 0, i)) {
//                 validSuffixes.add(word.substring(i + 1, n));
//             }
//         }
//         return validSuffixes;
//     }
    
//     private boolean isPalindromeBetween(String word, int front, int back) {
//         while (front < back) {
//             if (word.charAt(front) != word.charAt(back)) {
//                 return false;
//             }
//             front++;
//             back--;
//         }
//         return true;
//     }
// }



// class Solution {
//     public List<List<Integer>> palindromePairs(String[] words) {
//         int n = words.length;
//         List<List<Integer>> res = new ArrayList<>();
//         for (int i = 0; i < n - 1; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (canFormPalindrome(words[i], words[j])) {
//                     res.add(new ArrayList<>(Arrays.asList(i, j)));
//                 }
//                 if (canFormPalindrome(words[j], words[i])) {
//                     res.add(new ArrayList<>(Arrays.asList(j, i)));
//                 }
//             }
//         }
//         return res;
//     }
    
//     private boolean canFormPalindrome(String s1, String s2) {
//         String sample = s1 + s2;
//         return (sample.equals(reverse(sample)));
//     }
    
//     private String reverse(String s) {
//         StringBuilder sb = new StringBuilder();
//         int n = s.length();
//         for (int i = n - 1; i >= 0; i--) {
//             sb.append(s.charAt(i));
//         }
//         return sb.toString();
//     }
// }


// class Solution {
//     public List<List<Integer>> palindromePairs(String[] words) {
//         int n = words.length;
//         List<List<Integer>> res = new ArrayList<>();
//         for (int i = 0; i < n - 1; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 String word1 = words[i];
//                 String word2 = words[j];
//                 Map<Character, Integer> map = new HashMap<>();
//                 for (char c : word1.toCharArray()) {
//                     map.put(c, map.getOrDefault(c, 0) + 1);
//                 }
//                 for (char c : word2.toCharArray()) {
//                     map.put(c, map.getOrDefault(c, 0) + 1);
//                 }
                
//                 if (!containsMoreThanOneOdd(map)) {
//                     if (canFormPalindrome(words[i], words[j])) {
//                         res.add(new ArrayList<>(Arrays.asList(i, j)));
//                     }
//                     if (canFormPalindrome(words[j], words[i])) {
//                         res.add(new ArrayList<>(Arrays.asList(j, i)));
//                     }
//                 }
//             }
//         }
//         return res;
//     }
    
//     private boolean containsMoreThanOneOdd(Map<Character, Integer> map) {
//         int count = 0;
//         for (int i : map.keySet()) {
//             if (i % 2 == 1) count++;
//         }
//         return count > 1;
//     }
    
//     private boolean canFormPalindrome(String s1, String s2) {
//         String sample = s1 + s2;
//         return (sample.equals(reverse(sample)));
//     }
    
//     private String reverse(String s) {
//         StringBuilder sb = new StringBuilder();
//         int n = s.length();
//         for (int i = n - 1; i >= 0; i--) {
//             sb.append(s.charAt(i));
//         }
//         return sb.toString();
//     }
// }

