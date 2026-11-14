package array.easy;

/*
3105. Longest Strictly Increasing or Strictly Decreasing Subarray
You are given an array of integers nums. Return the length of the longest subarray of nums which is either strictly increasing or strictly decreasing.

Input: nums = [1,4,3,3,2]
Output: 2

Explanation:
The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].
The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].
*/

public class LongestStrictlyIncOrDecSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        // Store the maximum increasing and decreasing subarray lengths
        int max = 1;
        int min = 1;

        // Track the current increasing and decreasing subarray lengths
        int maxCount = 1;
        int minCount = 1;

        for (int i = 0; i < nums.length - 1; i++) {

            // Check for a strictly increasing sequence
            if (nums[i] < nums[i + 1]) {
                maxCount++;
            } else {
                // Reset when the increasing sequence breaks
                maxCount = 1;
            }

            // Check for a strictly decreasing sequence
            if (nums[i] > nums[i + 1]) {
                minCount++;
            } else {
                // Reset when the decreasing sequence breaks
                minCount = 1;
            }

            // Update the longest increasing and decreasing lengths
            max = Math.max(max, maxCount);
            min = Math.max(min, minCount);
        }

        // Return the longer of the two monotonic subarrays
        return Math.max(max, min);
    }
}
