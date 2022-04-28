class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            map.putIfAbsent(pair[0], new ArrayList<Integer>());
            map.putIfAbsent(pair[1], new ArrayList<Integer>());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        
        int n = adjacentPairs.length + 1; // the 1-d array's length is always the number of pairs + 1
        int[] res = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            List<Integer> adj = entry.getValue();
            // use the first element or last element as the starting point, either is fine, since these would just be two arrays with reverse order
            if (adj.size() == 1) {
                res[0] = key;
                break;
            }
        }
        
        res[1] = map.get(res[0]).get(0); // the second element is the one that is adjacent tothe first element
        // the first element's List contains only one integer, so just get the first integer from the list
        
        for (int i = 2; i < n; i++) {
            // for example, when i = 2, res[i - 1] is the second element
            // map.get(secondElement) is the list which contains the second element and its adjacent neighbor
            List<Integer> adj = map.get(res[i - 1]);
            // res[i - 2] is the element that is also adjacent to the second element
            // since the list only contains two integer, one is the first element, the other should be the third element (i.e. res[i])
            // if the first element equals to the first element in the list
            if (res[i - 2] == adj.get(0)) {
                // then the second element in the list must be the third element for res
                res[i] = adj.get(1);
            } else { // if the first element equals to the second element in the list
                // then the first element in the list must be the third element for res
                res[i] = adj.get(0);
            }
        }
        
        return res;
    }
}