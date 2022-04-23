class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int lower = newInterval[0];
        int upper = newInterval[1];
        int index = 0;
        
        while (index < intervals.length && intervals[index][1] < lower) {
            res.add(intervals[index]);
            index++;
        }
        
        while (index < intervals.length && intervals[index][0] <= upper) {
            lower = Math.min(lower, intervals[index][0]);
            upper = Math.max(upper, intervals[index][1]);
            index++;
        }
        
        res.add(new int[]{lower, upper});
        
        while (index < intervals.length) {
            res.add(intervals[index]);
            index++;
        }
        
        int[][] ans = new int[res.size()][2];
        int i = 0;
        for (int[] entry : res) {
            ans[i] = entry;
            i++;
        }
        
        return ans;
    }
}

// 9,12  15,18  22,24