class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length < 2) {
            return res;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                res.add(i);
            }
            else {
                set.add(i);
            }
        }
        return res;
    }
}