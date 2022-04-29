class Solution {
    public int brightestPosition(int[][] lights) {
        TreeMap<Integer, Integer> treemap = new TreeMap<>();
        for (int[] light : lights) {
            int pos = light[0];
            int interval = light[1];
            int start = pos - interval;
            int end = pos + interval + 1;
            // 用正数标记起点个数
            treemap.put(start, treemap.getOrDefault(start, 0) + 1);
            // 用负数标记终点个数
            // 之所以用负数标记右边界 是因为我们希望总是返回最小的边界点
            treemap.put(end, treemap.getOrDefault(end, 0) - 1);
        }
        
        int bright = 0; // 一个bright表示一个强度单位
        int maxBright = 0;
        int res = 0; // 最强光强的最左边的位置
        
        // 因为用treemap存了起点和终点，会进行自动排序(natural order, ascending)
        for (int bound : treemap.keySet()) { // 遍历光照的边界点, 从左到右
            // treemap.get(bound): 得到的是该位置被几盏灯照射
            bright += treemap.get(bound); // 因为起点的value是正数 so maxBright will always favor the left side than the right side
            if (bright > maxBright) {
                maxBright = bright;
                res = bound; // due the property that has been discussed on line 11, 12 and 23, the res will always record the left-most position that gets the most light
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