/*
Given an integer array nums of size n, return the minimum number of moves required to make
all array elements equal.

In one move, you can increment n - 1 elements of the array by 1.

Thinking -
- Key observation: Incrementing n - 1 elements is equivalent to decrementing the remaining element by 1.
- Optimal target: The minimum element in the array.
- Formula:
    moves = nums[i] - min
- Time Complexity: \(O(n)\) — two traversals.
- Space Complexity: \(O(1)\) — constant extra space.

Example -
nums = [1, 2, 3]   min = 1 here so
We need to bring everything down to 1.
- 1 needs 0 decrements.
- 2 needs 1 decrement.
- 3 needs 2 decrements.
Total:
0 + 1 + 2 = 3
*/
public class NumberOfMovesToMakeArrayEqual  {
    public int minMoves(int[] nums) {

        // Step 1: Find the minimum element
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
        }

        // Step 2: Calculate total moves
        // Each move is equivalent to decrementing one element by 1.
        // Therefore, bring every element down to the minimum.
        int moves = 0;

        for (int num : nums) {
            moves += num - min;
        }

        return moves;
    }
}
