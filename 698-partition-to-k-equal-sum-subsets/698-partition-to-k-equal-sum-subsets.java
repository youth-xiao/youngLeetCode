// https://www.geeksforgeeks.org/partition-set-k-subsets-equal-sum/

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) return true;
        int N = nums.length;
        if (N < k) return false;
        int total = 0;
        for (int i : nums) total += i;
        if (total % k != 0) return false;
        
        int subset = total / k;
        int[] subsetSum = new int[k];
        boolean[] taken = new boolean[N];
        
        Arrays.fill(subsetSum, 0);
        Arrays.fill(taken, false);
        
        subsetSum[0] = nums[N - 1];
        taken[N - 1] = true;
        
        return possiblePartitionRecursion(nums, subsetSum, taken, subset, k, N, 0, N - 1); // N - 1, because we've already use the last element in subsetSum
    }
    
    /*
    Our goal reduces to divide array into K parts where sum of each part should be array_sum/K 
    In below code a recursive method is written which tries to add array element into some subset.
    If sum of this subset reaches required sum, we iterate for next part recursively, otherwise 
    we backtrack for different set of elements. If number of subsets whose sum reaches the required sum is (K-1), 
    we flag that it is possible to partition array into K parts with equal sum, because remaining elements already
    have a sum equal to required sum. 
    */
    
    private boolean possiblePartitionRecursion(int nums[], int subsetSum[], boolean taken[],
                                              int subset, int k, int N, int currIndex, int limitIndex) {
        // limitIndex: the upper bound for iterating through int[] nums to get subset sum equals to sum/k
        // currIndex: refers to the index used in subsetSum, instead of int[] nums
        if (subsetSum[currIndex] == subset) {
            
            /* current index (k - 2) represents (k - 1) subsets of equal
            sum last partition will already remain with sum 'subset' */
            if (currIndex == k - 2) { // this means we have filled (k - 1) subsets that have valid subset sum expected, so the remaining one must have a legal subset sum
                return true; // this is the final return of true
            } else { // if we still have more than one subset to search, we still need to do recursion -> we need to move to the next position to be filled with subset sum in int[] subsetSum by incrementing currIndex by 1
                return  possiblePartitionRecursion(nums, subsetSum, taken, subset, k, N, currIndex + 1, N - 1);
            }
        } else { // we do not increment currIndex if we have not found a subset with sum of expected subset sum
            for (int i = limitIndex; i >= 0; i--) { // we start at the tail of int[] nums, because we have used the last element of int[] nums
                if (taken[i]) {
                    continue;
                } // we don't use this element if it has been used in other subset in this round of experiment
                else {
                    int temp = subsetSum[currIndex] + nums[i];
                    if (temp <= subset) { // not yet exceeds expected subset sum
                        taken[i] = true; // use nums[i] as the element of a subset sum
                        subsetSum[currIndex] += nums[i]; // update subsetSum by adding nums[i]
                        boolean next = possiblePartitionRecursion(nums, subsetSum, taken, subset, k, N, currIndex, i - 1);
                        taken[i] = false; // backtrack, unmark it as unused
                        subsetSum[currIndex] -= nums[i]; // backtrack subsetSum by removing nums[i]
                        if (next) return true;
                    }
                }
            }
        }
        return false;
    }
}