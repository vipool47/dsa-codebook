package greedyalgorithms;/*
Problem Definition:
-------------------
You are given an array of non-negative integers `nums`. Each element in the array represents your
maximum jump length at that position.

Your task is to determine if you are able to reach the last index starting from the first index.

Return `true` if you can reach the last index, otherwise return `false`.

Constraints:
------------
- Each element in the array represents how far you can jump from that position.
- You can only jump to the right (forward).
- If you ever land on a position that cannot move forward and hasn't reached the last index, return false.

Approach:
---------
- Use a greedy approach by keeping track of the maximum reachable index (`maxReach`).
- Iterate through the array:
   - If the current index is greater than `maxReach`, return false (you can't reach it).
   - Update `maxReach` to the farthest index you can reach from the current position.
   - If `maxReach` reaches or exceeds the last index, return true.
*/

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // If we can't reach the current position, return false
            if (i > maxReach) {
                return false;
            }

            // Update the maximum reachable position
            maxReach = Math.max(maxReach, i + nums[i]);

            // If we can reach the last index, return true
            if (maxReach >= n - 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 3, 1, 1, 4};  // Expected: true
        int[] nums2 = {3, 2, 1, 0, 4};  // Expected: false

        System.out.println("Can jump (nums1): " + canJump(nums1));
        System.out.println("Can jump (nums2): " + canJump(nums2));
    }
}


/*
    Step by step: why first condition is important
    i = 0
    maxReach = max(0, 0 + 3) = 3
    i = 1
    maxReach = max(3, 1 + 2) = 3
    i = 2
    maxReach = max(3, 2 + 1) = 3
    i = 3
    maxReach = max(3, 3 + 0) = 3
    i = 4
    ❌ i (4) > maxReach (3) → cannot reach index 4

    So we immediately return false.
 */