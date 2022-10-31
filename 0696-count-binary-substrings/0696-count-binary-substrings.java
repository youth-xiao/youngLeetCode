class Solution {
    public int countBinarySubstrings(String s) {
        int curr = 1;
        int prev = 0;
        int result = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                result += Math.min(curr, prev);
                prev = curr;
                curr = 1;
            }
        }
        
        return result + Math.min(curr, prev);
    }
}