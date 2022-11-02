class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int insertIndex = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[insertIndex - 1]) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }
}