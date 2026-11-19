package bitmanipulation;

/*
Given an integer n, return true if it is a power of two. Otherwise, return false.
An integer n is a power of two, if there exists an integer x such that n == 2x.

Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1

Input: n = 16
Output: true
Explanation: 24 = 16
 */
public class PowerOfTwo {
    // Optimal TC & SC = O(1)
    public boolean isPowerOfTwo(int n) {

        //If a number n is a power of two, that means it has exactly one bit set in its binary representation.
        /*
        1  -> 0001
        2  -> 0010
        4  -> 0100
        8  -> 1000
        if you take n and do n & (n - 1) — this operation turns off the rightmost set bit.
        For powers of two, n & (n - 1) becomes 0.
        For anything else, it’s non-zero.
         */
        return n > 0 && (n & (n - 1)) == 0;
    }

    // Brute force (run loop) TC = O(logN) SC= O(1)
    public boolean isPoweroftwo(int n) {
        if (n <= 0) return false;
        int power = 1;
        while (power < n) {
            power *= 2;
        }
        return power == n;
    }
}
