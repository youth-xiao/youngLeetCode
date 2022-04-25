// class Solution { // TLE
//     public int triangleNumber(int[] nums) {
//         int n = nums.length;
//         int count = 0;
//         for (int i = 0; i < n - 2; i++) {
//             for (int j = i + 1; j < n - 1; j++) {
//                 for (int k = j + 1; k < n; k++) {
//                     if (nums[i] + nums[j] > nums[k] 
//                     && nums[i] + nums[k] > nums[j] 
//                     && nums[j] + nums[k] > nums[i]) {
//                         count++;
//                     }
//                 }
                
//             }
//         }
//         return count;
//     }
// }

class Solution { // greedy
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] sort = new int[n]; // sort as ascending order
        // can't use Collections.reverseOrder() for primitive data types
        int index = n - 1;
        // manually reverse it
        for (int i : nums) {
            sort[index] = i;
            index--;
        }
        
        int count = 0;
        
        // int at index a is always the largest one
        for (int a = 0; a < n - 2; a++) {
            // index b is always the one next to a
            int b = a + 1;
            int c = n - 1; // index c is always start from the end of the sorted array
            // as long as b and c do not merge
            while (b < c) {
                if (sort[b] + sort[c] > sort[a]) {
                    // if sort[b] + sort[c] > sort[a], it means that any numbers larger than sort[c] (any number on the left of sort[c]) can satisfy the condition
                    count += (c - b);
                    b++; // shrink the window
                } else { // this means sort[c] is too small, we're trying to move index c to the left to point to larger int
                    c--;
                }
            }
        }
       
        return count;
    }
}