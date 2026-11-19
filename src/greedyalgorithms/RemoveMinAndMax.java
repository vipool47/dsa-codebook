package greedyalgorithms;

/*
You are given a 0-indexed array of distinct integers nums.

There is an element in nums that has the lowest value and an element that has the highest value. 
We call them the minimum and maximum respectively. 
Your goal is to remove both these elements from the array.

A deletion is defined as either removing an element from the front of the array 
or removing an element from the back of the array.

Return the minimum number of deletions it would take to remove 
both the minimum and maximum element from the array.

Input: nums = [2,10,7,5,4,1,8,6]
Output: 5

Input: nums = [0,-4,19,1,8,-2,-3,5]
Output: 3

Input: nums = [101]
Output: 1
*/
public class RemoveMinAndMax {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int minIndex = -1;
        int maxIndex = -1;

        // Find min, max and their indices
        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        // Remove both from the left
        int left = Math.max(minIndex, maxIndex) + 1;

        // Remove both from the right
        int right = n - Math.min(minIndex, maxIndex);

        // Remove min from left and max from right
        int minLeftMaxRight = (minIndex + 1) + (n - maxIndex);

        // Remove max from left and min from right
        int maxLeftMinRight = (maxIndex + 1) + (n - minIndex);

        // Return the minimum number of deletions
        return Math.min(
                Math.min(left, right),
                Math.min(minLeftMaxRight, maxLeftMinRight));
    }
}
