package slidingwindow.twopointer;

import java.util.Set;
import java.util.HashSet;

/*
Given two integer arrays nums1 and nums2, sorted in non-decreasing order, 
return the minimum integer common to both arrays. 
If there is no common integer amongst nums1 and nums2, return -1.

Note that an integer is said to be common to nums1 and nums2 
if both arrays have at least one occurrence of that integer.

Input: nums1 = [1,2,3], nums2 = [2,4]
Output: 2
Explanation: The smallest element common to both arrays is 2, so we return 2.
*/
public class MinimumCommonValue {
    // Optimized solution using two pointers TC: O(n1 + n2) SC: O(1)
    public int getCommon(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int left = 0;
        int right =  0;

        while(left < n1 && right < n2){
            if(nums1[left] == nums2[right]){
                return nums1[left];
            }
            else if(nums1[left] < nums2[right]){
                left++;
            }
            else{
                right++;
            }
        }

        return -1;
    }

    // Better solution using HashSet TC: O(n1 + n2) SC: O(n1)
    public int getCommonBetter(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums1){
            set.add(num);
        }
        for(int num : nums2){
            if(set.contains(num)){
                return num;
            }
        }

        return -1;
    }
}
