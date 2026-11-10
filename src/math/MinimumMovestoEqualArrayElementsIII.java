/*
3736. Minimum Moves to Equal Array Elements III

You are given an integer array nums.
In one move, you may increase the value of any single element nums[i] by 1.
Return the minimum total number of moves required so that all elements in nums become equal.

Input: nums = [2,1,3]
Output: 3
*/

public class MinimumMovestoEqualArrayElementsIII {

    public int minMoves(int[] nums) {
        int max = -1;
        int result = 0;

        // find maximum element
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        // subtract every element from the max to get how much it will need to be equal to max
        for (int n : nums) {
            result = result + (max - n);
        }

        return result;
    }
}
