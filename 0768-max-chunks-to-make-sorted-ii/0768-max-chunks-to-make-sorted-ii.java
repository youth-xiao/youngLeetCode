// class Solution {
//     public int maxChunksToSorted(int[] arr) {
//         int n = arr.length;
//         int pivotMax[] = new int[n];
        
//         pivotMax[0] = arr[0];
        
//         for (int i = 1; i < n; i++) {
//             pivotMax[i] = Math.max(arr[i], pivotMax[i - 1]);
//         }
        
//         int pivotMin[] = new int[n];
//         pivotMin[n - 1] = arr[n - 1];
        
//         for (int i = n - 2; i >= 0; i--) {
//             pivotMin[i] = Math.min(arr[i], pivotMin[i + 1]);
//         }
        
//         int count = 0;
        
//         for (int i = 0; i < n - 1; i++) {
//             if (pivotMax[i] <= pivotMin[i + 1]) {
//                 count++;
//             }
//         }
        
//         return count + 1;
//     }
// }


class Solution {
//     public int maxChunksToSorted(int[] arr) {
//         LinkedList<Integer> stack = new LinkedList<>();
//         for (int i : arr) {
//             if (!stack.isEmpty() && i < stack.getLast()) {
//                 int head = stack.removeLast();
//                 while (!stack.isEmpty() && i < stack.getLast()) {
//                     stack.removeLast();
//                 }
//                 stack.addLast(head);
//             } else {
//                 stack.addLast(i);
//             }
//         }
//         return stack.size();
//     }
    
    public int maxChunksToSorted(int[] arr) {
        int[] clone = arr.clone();
        Arrays.sort(clone);
        int n = arr.length;
        int ans = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0, total = 0; i < n; i++) {
            int a = arr[i];
            int b = clone[i];
            if (map.getOrDefault(a, 0) == -1) {
                total--;
            } else if (map.getOrDefault(a, 0) == 0) {
                total++;
            }
            map.put(a, map.getOrDefault(a, 0) + 1);
            
            if (map.getOrDefault(b, 0) == 1) {
                total--;
            } else if (map.getOrDefault(b, 0) == 0) {
                total++;
            }
            
            map.put(b, map.getOrDefault(b, 0) - 1);
            
            if (total == 0) {
                ans++;
            }
        }
             
        return ans;
    }
}