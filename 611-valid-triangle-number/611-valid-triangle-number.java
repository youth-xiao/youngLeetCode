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
        int[] sort = new int[n];
        int index = n - 1;
        for (int i : nums) {
            sort[index] = i;
            index--;
        }
        
        int count = 0;
        
        for (int a = 0; a < n - 2; a++) {
            int b = a + 1;
            int c = n - 1;
            while (b < c) {
                if (sort[b] + sort[c] > sort[a]) {
                    count += (c - b);
                    b++;
                } else {
                    c--;
                }
            }
        }
       
        return count;
    }
}