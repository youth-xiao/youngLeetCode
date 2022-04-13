class Solution {
    public int maxLength(List<String> arr) {
        List<String> words = new ArrayList<>();
        words.add("");
        int best = 0;
        for (String s : arr) {
            int wordsLength = words.size();
            for (int i = 0; i < wordsLength; i++) {
                String newStr = s + words.get(i);
                Set<Character> set = new HashSet<>();
                for (char c : newStr.toCharArray()) {
                    set.add(c);
                }
                if (set.size() != newStr.length()) {
                    continue;
                } else {
                    words.add(newStr);
                    best = Math.max(best, newStr.length());
                }
            }
        }
        return best;
    }
}