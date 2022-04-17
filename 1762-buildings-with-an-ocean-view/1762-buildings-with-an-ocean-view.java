class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        boolean[] views = new boolean[n];
        Arrays.fill(views, false);
        views[n - 1] = true;
        int maxHeight = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (heights[i] > heights[i + 1] && heights[i] > maxHeight) {
                views[i] = true;
                maxHeight = heights[i];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (views[i] == true) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (int k : list) {
            res[index] = k;
            index++;
        }
        return res;
    }
}