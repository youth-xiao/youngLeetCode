class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        zeroCount = 0
        left = right = longest = 0
        while right < len(nums):
            if nums[right] == 0:
                zeroCount += 1
            while zeroCount >= 2:
                if nums[left] == 0:
                    zeroCount -= 1
                left += 1
            longest = max(longest, right - left + 1)
            right += 1
        return longest