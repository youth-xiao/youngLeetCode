class Solution {
    public int minIncrementForUnique(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int move = 0;
        int need = 0;
        for (int key : map.keySet()) {
            int val = map.get(key);
            move += val * Math.max(need - key, 0) + val * (val - 1) / 2;
            need = Math.max(need, key) + val;
        }

        return move;
    }
}