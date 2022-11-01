class Solution:
    def minAvailableDuration(self, slots1: List[List[int]], slots2: List[List[int]], duration: int) -> List[int]:
        # sort based on start time, because the question ensures that there is no overlapping intervals within each individual, so that if an interval starts earlier, it will end earlier
        slots1.sort()
        slots2.sort()
        
        pointer1 = pointer2 = 0 # two pointers are used for two people respectively, not for a single person
        
        while pointer1 < len(slots1) and pointer2 < len(slots2):
            # try to think: to find overlap, we want to centralize/squeeze, which means we want the starting time (left bound) has right-ward tendency, ending time (right bound) has left-ward tendency. Therefore, for left_bound, we find max.
            left_bound = max(slots1[pointer1][0], slots2[pointer2][0])
            right_bound = min(slots1[pointer1][1], slots2[pointer2][1])
            overlap = right_bound - left_bound
            if (overlap >= duration):
                return [left_bound, left_bound + duration]
            # this means person 1's current interval ends earlier, so need to increment its pointer to start on the next interval
            if slots1[pointer1][1] < slots2[pointer2][1]:
                pointer1 += 1
            else:
                pointer2 += 1
                
        return[]