class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        total_len = len(nums1) + len(nums2)
        if total_len % 2 == 1:
            return self.kth(nums1, nums2, total_len // 2)
        else:
            return (self.kth(nums1, nums2, total_len // 2) + self.kth(nums1, nums2, total_len // 2 - 1)) / 2.
        
    
    def kth(self, nums1, nums2, k):
        if not nums1:
            return nums2[k]
        if not nums2:
            return nums1[k]
        nums1_med_ind = len(nums1) // 2
        nums2_med_ind = len(nums2) // 2
        nums1_med = nums1[nums1_med_ind]
        nums2_med = nums2[nums2_med_ind]
        
        if nums1_med_ind + nums2_med_ind < k:
            if nums1_med > nums2_med:
                return self.kth(nums1, nums2[nums2_med_ind + 1:], k - nums2_med_ind - 1)
            else:
                return self.kth(nums1[nums1_med_ind + 1:], nums2, k - nums1_med_ind - 1)
        else:
            if nums1_med > nums2_med:
                return self.kth(nums1[:nums1_med_ind], nums2, k)
            else:
                return self.kth(nums1, nums2[:nums2_med_ind], k)
