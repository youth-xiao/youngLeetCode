class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{start, end});
        for (int i = 1; i < intervals.length; i++) {
            int[] sub = intervals[i];
            int m = sub[0];
            int n = sub[1];
            if (m <= end && n >= end) {
                end = n;
                result.remove(result.size() - 1);
                result.add(new int[]{start, end});
            }
            else if (m > end) {
                start = m;
                end = n;
                result.add(new int[]{start, end});
            } 
            // else if (m < start && n >= end) {
            //     start = m;
            //     end = n;
            //     result.add(new int[]{start, end});
            // }
        }
        
        int[][] answer = new int[result.size()][2];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}