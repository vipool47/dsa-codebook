package array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
ou are given a 0-indexed integer array nums and a target element target.

A target index is an index i such that nums[i] == target.

Return a list of the target indices of nums after sorting nums in non-decreasing order. 
If there are no target indices, return an empty list. 
The returned list must be sorted in increasing order.

Input: nums = [1,2,5,2,3], target = 2
Output: [1,2]
Explanation: After sorting, nums is [1,2,2,3,5].
The indices where nums[i] == 2 are 1 and 2.
*/
public class FindTargetIndices {
    // --- Optimal ---
    public List<Integer> targetIndices(int[] nums, int target) {
        int smallerNums = 0;
        int count = 0;
        List<Integer> ans = new ArrayList<>();

        // count the nums that are smaller than tagert and equal to the target
        for(int i=0; i<nums.length; i++){
            if(nums[i] < target){
                smallerNums++;
            }

            if(nums[i] == target){
                count++;
            }
        }

        // start from the index of the first target element and 
        // add all the target elements to the list
        for(int i=smallerNums; i<smallerNums + count; i++){
            ans.add(i);
        }

        return ans;
    }

    // --- Brute Force ---
    public List<Integer> targetIndicesBruteForce(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                ans.add(i);
            }
        }

        return ans;
    }
}
