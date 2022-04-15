class Solution {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) return true;
        boolean foundZero = false;
        for (int i : arr) {
            if (i == 0) {
                foundZero = true;
            }
        }
        
        if (foundZero == false) {
            return false;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        visited[start] = true;
        
        
        while (!queue.isEmpty()) {
            int currIndex = queue.poll();
            int currSteps = arr[currIndex];
            
            int prevPos = currIndex - currSteps;
            int nextPos = currIndex + currSteps;
            
            
            if (prevPos >= 0 && visited[prevPos] == false) {
                if (arr[prevPos] == 0) {
                    return true;
                } else {
                    queue.offer(prevPos);
                    visited[prevPos] = true;
                }
            }
            
            if (nextPos < n && visited[nextPos] == false) {
                if (arr[nextPos] == 0) {
                    return true;
                } else {
                    queue.offer(nextPos);
                    visited[nextPos] = true;
                }
            }
            
        }
        return false;
    }
    
    
}