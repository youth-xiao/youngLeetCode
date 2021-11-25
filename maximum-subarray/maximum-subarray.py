class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        curr_sum = 0
        max_sum = float('-inf')
        for i in nums:
            curr_sum += i
            max_sum = max(curr_sum, max_sum)
            if curr_sum < 0:
                curr_sum = 0
        return max_sum