package hashmap.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
2913. Subarrays Distinct Element Sum of Squares I

You are given a 0-indexed integer array nums.
The distinct count of a subarray of nums is defined as:
    Let nums[i..j] be a subarray of nums consisting of all the indices from i to j such that 0 <= i <= j < nums.length. 
    Then the number of distinct values in nums[i..j] is called the distinct count of nums[i..j].
Return the sum of the squares of distinct counts of all subarrays of nums.

Input: nums = [1,2,1]
Output: 15
Explanation: Six possible subarrays are:
[1]: 1 distinct value
[2]: 1 distinct value
[1]: 1 distinct value
[1,2]: 2 distinct values
[2,1]: 2 distinct values
[1,2,1]: 2 distinct values
The sum of the squares of the distinct counts of all subarrays is 1 + 1 + 1 + 4 + 4 + 4 = 15.
*/
public class SubarrayDistinctElementsSum {
    public int sumCounts(List<Integer> nums) {
        int result = 0;
        int n = nums.size();

        for(int i=0; i<n; i++){
            Set<Integer> set = new HashSet<>();

            for(int j=i; j<n; j++){
                set.add(nums.get(j));

                int distinct = set.size();
                result = result +  distinct * distinct;
            }
        }

        return result;
    }

    // Dry run:
    /*
    Suppose nums = [1, 2, 1].
    Subarray	Distinct elements	Square
    [1]	            1	                1
    [1, 2]	        2	                4
    [1, 2, 1]	    2	                4
    [2]	            1	                1
    [2, 1]	        2	                4
    [1]	            1	                1
                            Total		15
    */
}
