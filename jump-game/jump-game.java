enum Index {
    GOOD, BAD, UNKNOWN
}

class Solution {
    Index[] memo;
    
    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }
    
    public boolean canJumpFromPosition(int pos, int[] nums) {
        if (memo[pos] != Index.UNKNOWN) {
            return memo[pos] == Index.GOOD ? true : false;
        }
        int furthestJump = Math.min(pos + nums[pos], nums.length - 1);
        for (int nextPos = pos + 1; nextPos <= furthestJump; nextPos++) {
            if (canJumpFromPosition(nextPos, nums)) {
                memo[pos] = Index.GOOD;
                return true;
            }
        }
        memo[pos] = Index.BAD;
        return false;
    }
}