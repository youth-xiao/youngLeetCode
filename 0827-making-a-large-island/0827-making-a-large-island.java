class Solution {
    public int largestIsland(int[][] grid) {
        int singleLargestIsland = 0;
        int n = grid.length;
        int index = 2;
        Map<Integer, Integer> areaMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = islandDFS(grid, i, j, index);
                    // singleLargestIsland = Math.max(singleLargestIsland, area);
                    areaMap.put(index, area);
                    index++;
                }
            }
        }
        
        if (areaMap.size() == 0) return 1;
        
        int largeIslandMax = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = helper(grid, i, j, areaMap);
                    if (set.size() == 0) continue;
                    largeIslandMax = Math.max(largeIslandMax, set.stream().map(item -> areaMap.get(item)).reduce(Integer::sum).orElse(0) + 1);

                    // largeIslandMax = Math.max(largeIslandMax, Math.max(newArea, singleLargestIsland));
                }
            }
        }
        
        if (largeIslandMax == 0) return areaMap.get(2);        
        return largeIslandMax;
    }
    
    private Set<Integer> helper(int[][] grid, int i, int j, Map<Integer, Integer> areaMap) {
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int[] dir : directions) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (withinBound(grid, row, col)) {
                if (grid[row][col] != 0) {
                    set.add(grid[row][col]);
                }
            }
        }
        return set;
    }

    
    private boolean withinBound(int[][] grid, int row, int col) {
        int n = grid.length;
        return row >= 0 && row < n && col >= 0 && col < n;
    }
    
    private int islandDFS(int[][] grid, int row, int col, int index) {
        if (!withinBound(grid, row, col)) return 0;
        
        if (grid[row][col] != 1) return 0;
        
        grid[row][col] = index;
        
        return 1 + islandDFS(grid, row + 1, col, index)
            + islandDFS(grid, row - 1, col, index)
            + islandDFS(grid, row, col + 1, index)
            + islandDFS(grid, row, col - 1, index);
    }
}