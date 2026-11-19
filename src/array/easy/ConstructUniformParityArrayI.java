package array.easy;

/*
You are given an array nums1 of n distinct integers.

You want to construct another array nums2 of length n such that the elements in nums2 are either all odd or all even.

For each index i, you must choose exactly one of the following (in any order):
    nums2[i] = nums1[i]
    nums2[i] = nums1[i] - nums1[j], for an index j != i

Return true if it is possible to construct such an array, otherwise, return false.



Input: nums1 = [2,3]
Output: true

Explanation:
    Choose nums2[0] = nums1[0] - nums1[1] = 2 - 3 = -1.
    Choose nums2[1] = nums1[1] = 3.
    nums2 = [-1, 3], and both elements are odd. Thus, the answer is true​​​​​​​.

Example 2:
Input: nums1 = [4,6]
Output: true

Explanation:​​​​​​​
    Choose nums2[0] = nums1[0] = 4.
    Choose nums2[1] = nums1[1] = 6.
    nums2 = [4, 6], and all elements are even. Thus, the answer is true.


Answer hint -
Suppose:
nums1 = [2, 4, 7, 9]

We have two even and two odd numbers.

We can simply choose 7 as our reference:
Original	Operation	Result
2 (Even)	2 - 7	    -5 (Odd)
4 (Even)	4 - 7	    -3 (Odd)
7 (Odd)	    Keep 7	     7 (Odd)
9 (Odd)	    Keep 9	     9 (Odd)

If all elements already have the same parity → we're done.
If both even and odd elements exist → pick any odd element as the reference.
Subtract that odd element from every even element.
Every resulting element is odd.
Original odd elements can remain unchanged.
*/

public class ConstructUniformParityArrayI {
    public boolean uniformArray(int[] nums1) {
        return true;
    }
}
