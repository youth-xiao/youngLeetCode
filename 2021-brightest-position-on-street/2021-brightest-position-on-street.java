class Solution {
    public int brightestPosition(int[][] lights) {
        TreeMap<Integer, Integer> treemap = new TreeMap<>();
        for (int[] light : lights) {
            int pos = light[0];
            int interval = light[1];
            int start = pos - interval;
            int end = pos + interval + 1;
            treemap.put(start, treemap.getOrDefault(start, 0) + 1);
            treemap.put(end, treemap.getOrDefault(end, 0) - 1);
        }
        
        int bright = 0;
        int maxBright = 0;
        int res = 0;
        
        for (int bound : treemap.keySet()) {
            bright += treemap.get(bound);
            if (bright > maxBright) {
                maxBright = bright;
                res = bound;
            }
        }
        
        return res;
    }
}


// class Solution {
//     public int brightestPosition(int[][] lights) {
//         int m = lights.length;
//         int[][] ranges = new int[m][2];
//         int index = 0;
//         for (int[] light : lights) {
//             int pos = light[0];
//             int r = light[1];
//             ranges[index] = new int[]{pos - r, pos + r};
//             index++;
//         }
        
//         // [[-3,2],[1,2],[3,3]]
//         // [[-5,-1],[-1,3],[0,6]]
        
//         Map<Integer, Integer> map = new HashMap<>();
        
//         for (int[] range : ranges) {
//             int start = range[0];
//             int end = range[1];
//             for (int i = start; i <= end; i++) {
//                 map.put(i, map.getOrDefault(i, 0) + 1);
//             }
//         }
        
//         TreeSet<Integer> maxBright = new TreeSet<>();
//         int max = 0;
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             max = Math.max(max, entry.getValue());
//         }
        
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             if (entry.getValue() == max) {
//                 maxBright.add(entry.getKey());
//             }
//         }
        
//         return maxBright.first();
        
//     }
// }