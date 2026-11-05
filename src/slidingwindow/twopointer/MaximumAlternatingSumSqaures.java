package slidingwindow.twopointer;

import java.util.Arrays;

/*
You are given an integer array nums. You may rearrange the elements in any order.
The alternating score of an array arr is defined as:
    score = arr[0]2 - arr[1]2 + arr[2]2 - arr[3]2 + ...
Return an integer denoting the maximum possible alternating score of nums after rearranging its elements.

Input: nums = [1,-1,2,-2,3,-3]
Output: 16
Explanation:
A possible rearrangement for nums is [-3,-1,-2,1,3,2], 
which gives the maximum alternating score among all possible rearrangements.
The alternating score is calculated as:
score = (-3)2 - (-1)2 + (-2)2 - (1)2 + (3)2 - (2)2 = 9 - 1 + 4 - 1 + 9 - 4 = 16
*/


/*
Time: (O(nlog n)) — sorting dominates.

Extra space: (O(log n)) typically for Java's Arrays.sort(int[]) 
implementation, due to its internal sorting stack.
*/
public class MaximumAlternatingSumSqaures {
    public long maxAlternatingSum(int[] nums) {
        // make array positive 
        for(int i=0; i<nums.length; i++){
            nums[i] = Math.abs(nums[i]);
        }

        Arrays.sort(nums);

        long score = 0;
        int left = 0;
        int right = nums.length-1;
        
        // alternatively pick max and min and perform operation
        while(left < right){
            long rightS = (long) nums[right] * nums[right];
            long leftS = (long) nums[left] * nums[left];

            score += rightS;
            score -= leftS;

            left++;
            right--;
        }

        // if array has odd no of elements add the last element in score 
        if(left == right){
            score += (long) nums[left] * nums[left];
        }

        return score;
    }
}
