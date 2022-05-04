class Solution {
    public int lengthLongestPath(String input) {
        int maxLen = 0;
        String[] tokens = input.split("\n");
        int[] depthRecord = new int[input.length() + 1];
        
        for (String s : tokens) {
            String clean = s.replaceAll("\t", "");
            int depth = s.length() - clean.length();
            if (clean.contains(".")) {
                maxLen = Math.max(maxLen, depthRecord[depth] + clean.length());
            } else {
                depthRecord[depth + 1] = depthRecord[depth] + clean.length() + 1;
            }
        }
        
        return maxLen;
    }
}