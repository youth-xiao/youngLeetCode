class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean evenIndex = (right - mid) % 2 == 0;
            if (nums[mid] == nums[mid + 1]) {
                if (evenIndex) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if (evenIndex) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else {
                return nums[mid];
            }
            
            // if (mid % 2 == 0) { // even index
            //     if (nums[mid] == nums[mid - 1]) {
            //         right = mid - 1;
            //     } else if (nums[mid] == nums[mid + 1]) {
            //         left = mid + 1;
            //     } else {
            //         res = mid;
            //     }
            // } else { // odd index
            //     if (nums[mid] == nums[mid - 1]) {
            //         left = mid + 1;
            //     } else if (nums[mid] == nums[mid + 1]) {
            //         right = mid - 1;
            //     } else {
            //         res = mid;
            //     }
            // }
        }
        return nums[left];
    }
    
    /*
    [1,1,2,3,3,4,4,8,8]
    0,8 -> mid=4, which is 3 (2nd)
    0,3 -> mid=1, which is 1
    */
}