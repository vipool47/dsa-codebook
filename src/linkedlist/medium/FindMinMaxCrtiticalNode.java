package linkedlist.medium;

import java.util.ArrayList;
import java.util.List;

import linkedlist.ListNode;

/*
2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
A critical point in a linked list is defined as either a local maxima or a local minima.

A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.

A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.

Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.

Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] 
where minDistance is the minimum distance between any two distinct critical points and maxDistance is the maximum distance between any two distinct critical points. If there are fewer than two critical points, return [-1, -1].

Input: head = [5,3,1,2,5,1,2]
Output: [1,3]
Explanation: There are three critical points:
- [5,3,1,2,5,1,2]: The third node is a local minima because 1 is less than 3 and 2.
- [5,3,1,2,5,1,2]: The fifth node is a local maxima because 5 is greater than 2 and 1.
- [5,3,1,2,5,1,2]: The sixth node is a local minima because 1 is less than 5 and 2.
The minimum distance is between the fifth and the sixth node. minDistance = 6 - 5 = 1.
The maximum distance is between the third and the sixth node. maxDistance = 6 - 3 = 3
*/
public class FindMinMaxCrtiticalNode {
    // --------- Better Approach -----------
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int minDiff = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        int cpCount = 0;

        ListNode temp = head.next;
        int prev = head.val;
        // since head is skipped we start index from 1  
        int index = 1;

        List<Integer> list = new ArrayList<>();

        while (temp != null && temp.next != null) {
            int curr = temp.val;
            int nextVal = temp.next.val;

            if (curr < prev && curr < nextVal) {
                // local minima 
                list.add(index + 1);
                cpCount++;
            }

            if (curr > prev && curr > nextVal) {
                // local maxima
                list.add(index + 1);
                cpCount++;
            }

            prev = curr;
            temp = temp.next;
            index++;
        }

        // Less than 2 critical points
        if (cpCount < 2) {
            return new int[]{-1, -1};
        }

        // Calculate minimum and maximum distances
        minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < list.size(); i++) {
            // since minimum distance is between two consecutive critical points, we can calculate the difference between the current and previous critical point
            minDiff = Math.min(minDiff, list.get(i) - list.get(i - 1));
        }

        // maximum distance is between the first and last critical points (since we are storing it in array list the order of indexes is maintained)
        maxDiff = list.get(list.size() - 1) - list.get(0);

        return new int[]{minDiff, maxDiff};
    }
}
