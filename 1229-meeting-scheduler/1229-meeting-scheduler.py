class Solution:
    def minAvailableDuration(self, slots1: List[List[int]], slots2: List[List[int]], duration: int) -> List[int]:
        slots1.sort()
        slots2.sort()
        
        pointer1 = pointer2 = 0
        
        while pointer1 < len(slots1) and pointer2 < len(slots2):
            left_bound = max(slots1[pointer1][0], slots2[pointer2][0])
            right_bound = min(slots1[pointer1][1], slots2[pointer2][1])
            overlap = right_bound - left_bound
            if (overlap >= duration):
                return [left_bound, left_bound + duration]
            if slots1[pointer1][1] < slots2[pointer2][1]:
                pointer1 += 1
            else:
                pointer2 += 1
                
        return[]