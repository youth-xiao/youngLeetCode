class Solution {
    public int lengthLongestPath(String input) {
        int maxLen = 0;
        String[] tokens = input.split("\n");
        int[] depthRecord = new int[input.length() + 1]; // not all spots will be necessarily used
        // just to be safe to create more than enough spaces to store info
        
        for (String s : tokens) {
            String clean = s.replaceAll("\t", ""); // \t counts as one character, not two
            int depth = s.length() - clean.length(); // how many tabs are there
            if (clean.contains(".")) { // if it is a file, not a directory
                maxLen = Math.max(maxLen, depthRecord[depth] + clean.length());
            } else { // just a directory
                // depthRecord[depth]: its parent directory's length
                depthRecord[depth + 1] = depthRecord[depth] + clean.length() + 1; // +1: need to append "/" because it is not the end of the path if there is/are file(s) within it
            }
        }
        
        return maxLen;
    }
}