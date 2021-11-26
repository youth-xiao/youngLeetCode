class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            if (word.equals("")) {
                continue;
            }
            else {
                if (sb.length() == 0) {
                    sb.append(word.replaceAll("\\s+", ""));
                }
                else {
                    sb.append(" ");
                    sb.append(word.replaceAll("\\s+", ""));
                }
            }
        }
        // sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}