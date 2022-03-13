class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastOccur = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            lastOccur[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            end = Math.max(end, lastOccur[s.charAt(i) - 'a']);
            if (end == i) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}